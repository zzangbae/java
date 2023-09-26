import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Problem3t {
    public static final Pair NOT_EXISTS = new Pair(-1, -1);
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 100;
    
    public static int n, k;
    public static int[][] grid = new int[MAX_N][MAX_N];

    // 현재위치
    public static Pair currCell;
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    public static void initializeVisited() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                visited[i][j] = false;
    }

    public static boolean canGo(int x, int y, int targetNum) {
        return inRange(x, y) && !visited[x][y] && grid[x][y] < targetNum;
    }

    public static void BFS() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int cX = currCell.x;
        int cY = currCell.y;
        visited[cX][cY] = true;
        bfsQ.add(currCell);

        int targetNum = grid[cX][cY];

        while(!bfsQ.isEmpty()) {
            Pair currPos = bfsQ.poll();
            int currX = currPos.x;
            int currY = currPos.y;

            for(int i = 0; i < DIR_NUM; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                if(canGo(newX, newY, targetNum)) {
                    bfsQ.add(new Pair(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }

    }
    
    // best위치를 새로운 위치로 바꿔줘야 하는지를 판단
    public static boolean needUpdate(Pair bestPos, Pair newPos) {
        // 첫 도달 가능한 위치라면
        // 업데이터 필요
        if(bestPos.x == NOT_EXISTS.x && bestPos.y == NOT_EXISTS.y)
            return true;
        
        int bestX = bestPos.x;
        int bestY = bestPos.y;

        int newX = newPos.x;
        int newY = newPos.y;

        if(grid[newX][newY] != grid[bestX][bestY])
            return grid[newX][newY] > grid[bestX][bestY];
        if(-newX != -bestX)
            return -newX > -bestX;
        return -newY > -bestY;
    }

    // 가장 우선순위가 높은 위치를 찾아
    // 위치를 이동합니다.
    public static boolean move() {
        // 초기화 작업
        initializeVisited();

        // Step1. BFS를 진행하여 갈 수 있는 모든 점의 위치 구하기
        BFS();

        // Step2.
        // 도달할 수 있는 위치들 중
        // 가장 우선순위가 높은 위치를 구하기
        Pair bestPos = NOT_EXISTS;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                // 도달이 불가능하거나 현재위치는 건너뛰기
                if(!visited[i][j] || i == currCell.x && j == currCell.y)
                    continue;
                
                Pair newPos = new Pair(i, j);
                if(needUpdate(bestPos, newPos))
                    bestPos = newPos;
            }
        
        // Step3. 위치를 이동하기
        // 만일 움직일 위치가 없다면 종료
        if(bestPos.x == NOT_EXISTS.x && bestPos.y == NOT_EXISTS.y)
            return false;
        // 움직일 위치가 있다면 이동
        else {
            currCell = bestPos;
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // 초기 위치 설정
        int r = sc.nextInt();
        int c = sc.nextInt();
        currCell = new Pair(r - 1, c - 1);

        // k번에 걸쳐 움직이는 것을 반복
        while(k-- > 0) {
            boolean isMoved = move();

            // 움직이지 못했다면 바로 종료
            if(!isMoved)
                break;
        }

        int finalX = currCell.x;
        int finalY = currCell.y;

        System.out.println((finalX + 1) + " " + (finalY + 1));
    }
}
