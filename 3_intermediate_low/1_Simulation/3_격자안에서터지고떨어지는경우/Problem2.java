import java.util.*;

/*
 * 십자 모양 폭발
 * 11:20~
 */
public class Problem2 {
    public static final int MAX_N = 200;

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int bs;   // 폭발크기 boom size

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void boom(int x, int y) {
        final int[] dx = new int[]{-1, 1, 0, 0};  // 상하좌우
        final int[] dy = new int[]{0, 0, -1, 1};  // 상하좌우
        final int DIR_NUM = 4;
        
        for(int i = 0; i < DIR_NUM; i++) {
            for(int d = 0; d < bs; d++) {
                int nx = x + d * dx[i];
                int ny = y + d * dy[i];
                // 범위 안이면 터친다.
                if(inRange(nx, ny)) {
                    grid[nx][ny] = 0;
                }
            }
        }
    }

    // 폭탄이 (r, c)에서 터졌다. 이 때, 중력처리
    public static void gravity(int r, int c) {
        // c열을 제외한 처리
        // 모두 r행이 0이다.
        for(int j = c - bs + 1; j <= c + bs - 1; j++) {
            // c열은 따로 처리
            if(j == c)
                continue;
            // 위에서 중력 작용 -> 만약 맨 위에서 터졌더라도, for문이 돌지 않기 때문에 인덱스 에러 없음
            for(int i = r; i > 0; i--) {
                grid[i][j] = grid[i - 1][j];
            }
            // 맨 윗칸 처리
            grid[0][j] = 0;
        }

        // c열 처리
        for(int i = r + bs - 1; i >= r - bs + 1; i--) {
            if(i > 0 && i < n) {
                grid[i][c] = grid[i - 1][c];
            }
        }
        // 맨 윗칸 처리
        for(int i = 0; i < bs; i++) {
            grid[i][c] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();    
        // 터진 이후에는 중력에 의해 숫자들이 아래로 떨어짐
        // 숫자 커지면 십자 범위가 더 커짐
        // 터지는 곳
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        bs = grid[r][c];
        
        // 격자 내의 숫자는 1~100
        // 터진 곳은 0
        boom(r, c);

        // 중력
        gravity(r, c);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }    
}
