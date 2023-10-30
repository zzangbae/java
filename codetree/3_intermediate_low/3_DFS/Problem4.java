import java.util.*;
/**
 * 안전 지대
 */
public class Problem4 {
    public static final int MAX_N = 50;
    public static final int MAX_M = 50;
    public static final int DIR_NUM = 4;
    public static final int[] dx = new int[]{-1, 0, 1, 0};
    public static final int[] dy = new int[]{0, 1, 0, -1};

    public static int n;
    public static int m;
    public static int[][] grid = new int[MAX_N][MAX_M];
    public static boolean[][] visited = new boolean[MAX_N][MAX_M];
    
    public static boolean inRange(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m)
            return false;
        return true;
    }

    public static boolean canGo(int x, int y, int h) {
        if(!inRange(x, y))
            return false;
        // 들리지 않았고, h보다 위인 경우 
        if(visited[x][y] == true || grid[x][y] <= h)
            return false;
        return true;
    }

    public static void DFS(int x, int y, int h) {
        for(int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(canGo(nx, ny, h)) {
                visited[nx][ny] = true;
                DFS(nx, ny, h);
            }
        }        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // **전역으로 선언한 것을 다시 선언해버림;;;
        m = sc.nextInt();   // **전역으로 선언한 것을 다시 선언해버림;;;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // System.out.println(h_min + " " + h_max);

        int maxCnt = 0;    // 안전영역의 갯수
        int height = 1; // 안전영역이 가장 많은 때의 안전영역 높이
        for(int h = 1; h <= 100; h++) {
            // 방문 초기화
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++)
                    visited[i][j] = false;
            // 안전영역 갯수 초기화
            int tmpCnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    // h 초과인 점이고, 방문한 점이 아닌 경우
                    if(grid[i][j] > h && visited[i][j] == false) {
                        visited[i][j] = true;   // 방문처리
                        tmpCnt++;
                        DFS(i, j, h);
                    }
                }
            }
            // 더 많은 안전지대가 있다면, 갱신
            // > 이므로, 여러개의 최대가 되는 K가 여러개라면, 가장 작은 K가 나옴
            if(tmpCnt > maxCnt) {
                maxCnt = tmpCnt;
                height = h;
            }
        }
        System.out.println(height + " " + maxCnt);
    }
}
