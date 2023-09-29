import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 빙하
 * 21:16~22:16(1시간)
 */
public class Problem5 {
    public static final int MAX_N = 200;
    public static final int MAX_M = 200;
    public static final int[] dx = new int[]{-1, 1, 0, 0};
    public static final int[] dy = new int[]{0, 0, -1, 1};
    public static final int DIR_NUM = 4;
    
    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_M];
    public static boolean[][] visited = new boolean[MAX_N][MAX_M];  // 임시 결과치를 담음->녹으면서 영향끼치는 것을 막기위해
    public static Queue<Pair> q = new LinkedList<>();
    public static int t = 0;    // 시간
    public static int ice;  // 마지막으로 녹은 빙하의 크기가 들어갈 곳, 초기값은 녹이기전 체크

    // 모든 빙하가 다 녹으면 true, 아니면 false
    public static boolean isAllGone() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 하나라도 녹지 않은 것이 있다면 false
                if(grid[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    // ice 갯수를 세기
    public static void checkIce() {
        int cnt = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1)
                    cnt++;
            }
        // 다 녹았다면 갱신하지 않아도 된다.
        if(cnt == 0)
            return;
        ice = cnt;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1;
    }

    public static void initializeVis() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                visited[i][j] = false;
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            for(int i = 0; i < DIR_NUM; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위안에 있고, 해당 점이 0이라면, 그리고 들리지 않았더라면
                if(inRange(nx, ny) && grid[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static void meltIce() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j]) {
                    for(int k = 0; k < DIR_NUM; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(inRange(nx, ny))
                            grid[nx][ny] = 0;   // 녹인다.
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1)
                    ice++;
            }
        }
        
        while(true) {
            // 모든 곳이 이미 녹아있다면 멈춰라
            if(isAllGone())
                break;
            
            // visited 초기화
            initializeVis();

            // (0,0)에서 BFS를 돌리기
            visited[0][0] = true;
            q.add(new Pair(0, 0));
            BFS();

            // visited에 맞닿은 곳을 모두 0으로 바꾸기
            meltIce();
            // 빙하 갯수 세기
            checkIce();
            t++;
        }
        // 출력
        System.out.println(t + " " + ice);
    }
}
