import java.util.*;

/**
 * 2차원 바람
 * 18:42~ 19:15(33분)
 */
public class Problem4 {

    public static final int MAX_N = 100;
    public static final int MAX_M = 100;

    public static int n, m, q;
    public static int r1, c1, r2, c2;
    // index-1 활용
    public static int[][] grid = new int[MAX_N + 1][MAX_M + 1];
    public static int[][] tmp = new int[MAX_N + 1][MAX_M + 1];
    
    public static void rotation(int r1, int c1, int r2, int c2) {
        int t1 = grid[r1 + 1][c1];
        int t2 = grid[r1][c2];
        int t3 = grid[r2][c2];
        int t4 = grid[r2][c1];
        for(int i = c2; i > c1; i--) {
            grid[r1][i] = grid[r1][i - 1];
        }
        grid[r1][c1] = t1;

        for(int i = r2; i > r1 + 1; i--) {
            grid[i][c2] = grid[i - 1][c2];
        }
        grid[r1 + 1][c2] = t2;

        for(int i = c1; i < c2 - 1; i++) {
            grid[r2][i] = grid[r2][i + 1];
        }
        grid[r2][c2 - 1] = t3;

        for(int i = r1 + 1; i < r2 - 1; i++) {
            grid[i][c1] = grid[i + 1][c1];
        }
        grid[r2 - 1][c1] = t4;
    }

    public static boolean inRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= m;
    }

    public static void makeAvg(int r1, int c1, int r2, int c2) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int DIR_NUM = 4;
        
        for(int x = r1; x <= r2; x++) {
            for(int y = c1; y <= c2; y++) {
                int sum = grid[x][y];
                int cnt = 1;
                for(int i = 0; i < DIR_NUM; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(inRange(nx, ny)) {
                        sum += grid[nx][ny];
                        cnt++;
                    }
                }
                tmp[x][y] = sum / cnt;
            }
        }
        for(int i = r1; i <= r2; i++)
            for(int j = c1; j <= c2; j++)
                grid[i][j] = tmp[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                grid[i][j] = sc.nextInt();

        while(q-- > 0) {
            r1 = sc.nextInt();
            c1 = sc.nextInt();
            r2 = sc.nextInt();
            c2 = sc.nextInt();
            rotation(r1, c1, r2, c2);
            makeAvg(r1, c1, r2, c2);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
