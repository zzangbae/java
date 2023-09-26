import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/**
 * K번 최댓값으로 이동하기
 * 14:34~15:23(49분)
 */
public class Problem3 {
    public static final int MAX_N = 100;
    public static final int[] dx = new int[]{-1, 1, 0, 0};
    public static final int[] dy = new int[]{0, 0, -1, 1};
    public static final int DIR_NUM = 4;

    public static int n, k;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];
    public static Queue<Pair> q = new LinkedList<>();
    public static int maxP, startP; // startP: 시작점의 점수, maxP: 시작점의 점수보다 작은 값들 중 가장 큰 값
    public static int maxPr, maxPc; // maxP점의 r, c
    public static void initializeV() {
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                visited[i][j] = false;
    }
    public static boolean inRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }
    public static void BFS() {
        while(!q.isEmpty()) {   // ***!를 안찍어서 BFS가 돌고있지않았다!
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            // 다음점 갱신조건 - 다음점 조건: 최저값, r, c고려
            if(grid[x][y] < startP && grid[x][y] >= maxP) {
                if(grid[x][y] > maxP) {
                    maxP = grid[x][y];
                    maxPr = x;
                    maxPc = y;
                }
                else if(grid[x][y] == maxP) {
                    // 같은 값을 때는, 행번호가 작은곳
                    if(x < maxPr) {
                        maxPr = x;
                        maxPc = y;
                    }
                    // 행이 같을 경우, 열번호가 작은 곳
                    else if(x == maxPr) {
                        if(y < maxPc) {
                            maxPr = x;
                            maxPc = y;
                        }
                    }
                }
            }

            for(int i = 0; i < DIR_NUM; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 만약 다음점이 범위 안에 있고, startP값보다 작으며, 들리지 않았던 점이라면
                if(inRange(nx, ny) && grid[nx][ny] < startP && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }  
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                grid[i][j] = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();
        Pair start = new Pair(a, b);
        
        while(k-- > 0) {
            q.add(start);
            maxP = 0;
            maxPr = 0;
            maxPc = 0;
            startP = grid[start.x][start.y];
            // visited 초기화
            initializeV();
            visited[start.x][start.y] = true;
            // 1. BFS를 통해서 다음 점을 찾음
            BFS();
            // 1-1. 만약 다음점이 없다면 종료
            if(maxPr == 0 && maxPc == 0)
                break;
            // 1-2. 만약 다음점을 찾았다면 해당 점으로부터 BFS 수행
            start = new Pair(maxPr, maxPc); // 다음점 갱신
        }
        System.out.println(start.x + " " + start.y);
    }
}
