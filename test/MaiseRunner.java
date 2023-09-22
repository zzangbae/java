import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
};

public class MaiseRunner {

    public static final int MAX_N = 10;

    public static int n;    // 미로의크기 4~10
    public static int m;    // 참가자수 1~10
    public static int k;    // 게임시간 1~100
    
    // 모든 벽들의 상태 기록
    public static int[][] board = new int[MAX_N + 1][MAX_N + 1];
    
    // 회전의 구현을 편하게 하기 위해 2차원 배열을 하나 더 정의해주기
    public static int[][] nextBoard = new int[MAX_N + 1][MAX_N + 1];

    // 참가자의 위치 정보를 기록
    public static Pair[] traveler = new Pair[MAX_N + 1];

    // 출구의 위치 정보
    public static Pair exits;

    // 정답(모든 참가자들의 이동 거리 합)
    public static int ans;

    // 회전해야 하는 최소 정사각형
    public static int sx, sy, squareSize;

    // 한 명 이상의 참가자와 출구를 포함한 가장 작은 정사각형 찾기
    // -> 아이디어 : 완탐 ;; 모든 정사각형을 만들면서 조건을 판단함
    public static void findMinimimSquare() {
        // 가장 작은 정사각형부터 모든 정사각형을 만들기(sz : 사이즈)
        for(int sz = 2; sz <= n; sz++) {
            // 가장 좌상단 r 좌표가 작은 것부터
            for(int x1 = 1; x1 <= n - sz + 1; x1++) {
                // 가장 좌상단 c 좌표가 작은 것부터
                for(int y1 = 1; y1 <= n - sz + 1; y1++) {
                    int x2 = x1 + sz - 1;   // 우하단
                    int y2 = y1 + sz - 1;   // 우하단

                    // 만약 출구가 해당 정사각형에 없다면 스킵
                    if(!(x1 <= exits.x && exits.x <= x2 && y1 <= exits.y && exits.y <= y2)) {
                        continue;
                    }

                    // 한명 이상 참가자가 해당 정사각형 안에 있는지 판단
                    boolean isTravelerIn = false;
                    for(int l = 1; l <= m; l++) {
                        if(x1 <= traveler[l].x && traveler[l].x <= x2 && y1 <= traveler[l].y && traveler[l].y <= y2) {
                            // 출구에 있는 참가자는 제외
                            if(!(traveler[l].x == exits.x && traveler[l].y == exits.y)) {
                                isTravelerIn = true;
                            }
                        }
                    }

                    // 만약 한 명 이상의 참가자가 해당 정사각형 안에 있다면
                    // sx, sy, squareSize 정보 갱신 후 종료
                    if(isTravelerIn) {
                        sx = x1;
                        sy = y1;
                        squareSize = sz;

                        return;
                    }
                }
            }
        }
    }
    
    // 모든 참가자들을 이동
    public static void moveAllTraveler() {
        // m명의 참가자들에 대해 이동을 진행
        for(int i = 1; i <= m; i++) {
            // 이미 출구에 있는 경우 스킵
            if(traveler[i].x == exits.x && traveler[i].y == exits.y)
                continue;
            
            // 행이 다른 경우 행을 이동 -> 상하 먼저 이동하기 때문에 먼저
            if(traveler[i].x != exits.x) {
                int nx = traveler[i].x;
                int ny = traveler[i].y;

                if(exits.x > nx) nx++;
                else nx--;

                // 벽이 없다면 행을 이동시킬 수 있음
                // 이 경우 행을 이동시키고 바로 다음 참가자로 넘어감
                if(board[nx][ny] == 0) {
                    traveler[i].x = nx;
                    traveler[i].y = ny;
                    ans++;
                    continue;
                }
            }

            // 열이 다른 경우 열을 이동
            if(traveler[i].y != exits.y) {
                int nx = traveler[i].x;
                int ny = traveler[i].y;

                if(exits.y > ny) ny++;
                else ny--;

                // 벽이 없다면 행을 이동시킬 수 있음
                // 이 경우 열을 이동
                if(board[nx][ny] == 0) {
                    traveler[i].x = nx;
                    traveler[i].y = ny;
                    ans++;
                    continue;
                }
            }
        }
    }

    // 정사각형 내부의 벽을 회전 시키기
    public static void rotateSquare() {
        // 우선 정사각형 안에 있는 벽들을 1 감소 시킴
        for(int x = sx; x < sx + squareSize; x++)
            for(int y = sy; y < sy + squareSize; y++)
                if(board[x][y] > 0) board[x][y]--;
        
        // 정사각형을 시계방향으로 90`회전
        for(int x = sx; x < sx + squareSize; x++)
            for(int y = sy; y < sy + squareSize; y++) {
                // Step1. (sx, sy)를 (0, 0)으로 옮겨주는 변환
                int ox = x - sx, oy = y - sy;
                // Step2. 변환된 상태에서는 회전 이후의 좌표가 (x, y) -> (y, squareN - x - 1)
                int rx = oy, ry = squareSize - ox - 1;  // *** 왜 -1 까지 해주는가??
                // Step3. 다시 (sx, sy)를 더해주기
                nextBoard[rx + sx][ry + sy] = board[x][y];
            }
        
        // nextBoard 값을 현재 board에 옮겨줌
        for(int x = sx; x < sx + squareSize; x++)
            for(int y = sy; y < sy + squareSize; y++)
                board[x][y] = nextBoard[x][y];
    }

    // 모든 참가자들 및 출구를 회전
    public static void rotateTravelerAndExit() {
        // m명의 참가자들을 모두 확인
        for(int i = 1; i <= m; i++) {
            int x = traveler[i].x;
            int y = traveler[i].y;
            // 해당 참가자가 정사각형 안에 포함되어 있을 때에만 회전
            if(sx <= x && x < sx + squareSize && sy <= y && y < sy + squareSize) {
                // Step1. (sx, sy)를 (0, 0)으로 옮겨주는 변환
                int ox = x - sx, oy = y - sy;
                // Step2. 변환된 상태에서는 회전 이후의 좌포가 (x, y) -> (y, squareN - x - 1)
                int rx = oy, ry = squareSize - ox - 1;
                // Step3. 다시 (sx, sy)더하기
                traveler[i].x = rx + sx;
                traveler[i].y = ry + sy;
            }
        }

        // 출구에도 회전을 진행
        int x = exits.x;
        int y = exits.y;
        if(sx <= x && x < sx + squareSize && sy <= y && y < sy + squareSize) {
            // Step1. (sx, sy)를 (0, 0)으로 변환
            int ox = x - sx, oy = y - sy;
            // Step2. 변환된 상태에서는 회전 이후 좌표, 위와 동일
            int rx = oy, ry = squareSize - ox - 1;
            // Step3. 다시 (sx, sy)를 더해주기
            exits.x = rx + sx;
            exits.y = ry + sy;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                board[i][j] = sc.nextInt();
        
        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            traveler[i] = new Pair(x, y);
        }

        // 출구 좌표
        int x = sc.nextInt();
        int y = sc.nextInt();
        exits = new Pair(x, y);

        while(k-- > 0) {
            // 모든 참가자를 이동
            moveAllTraveler();

            // 모든 사람이 출구로 탈출했는지 판단
            boolean isAllEscaped = true;
            for(int i = 1; i <= m; i++) {
                if(!(traveler[i].x == exits.x && traveler[i].y == exits.y)) {
                    isAllEscaped = false;
                }
            }

            // 만약 모든 사람이 출구로 탈출했으면 바로 종료
            if(isAllEscaped) break;

            // 한 명 이상의 참가자와 출구를 포함한 가장 작은 정사각형 찾기
            findMinimimSquare();

            // 정사각형 내부의 벽을 회전 -> 회전 로직이 특이하다
            rotateSquare();

            // 모든 참가자들 및 출구를 회전
            rotateTravelerAndExit();
        }

        System.out.print(ans + "\n");
        System.out.print(exits.x + " " + exits.y);
    }
}