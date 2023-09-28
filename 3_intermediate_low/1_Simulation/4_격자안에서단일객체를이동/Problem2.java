import java.util.*;

/**
 * 떨어지는 1자 블록
 */
public class Problem2 {
    public static int MAX_N = 100;

    public static int n, m, k;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                grid[i][j] = sc.nextInt();
        
        // 벽이 떨어지는 열들 중에 가장 높은 열 + 1칸에 떨어진다.
        int h = n;  // 맨 맡에 까지 떨어지는 경우
        for(int i = 1; i <= n; i++) {
            boolean isChecked = false;  // 높이를 찾은 경우 true;
            for(int j = k; j <= k + m - 1; j++) {
                if(grid[i][j] == 1) {
                    h = i - 1;
                    isChecked = true;
                    break;
                }
            }
            if(isChecked)
                break;
        }
        
        for(int j = k; j <= k + m - 1; j++) {
            grid[h][j] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
    /**
     * 제외한 예외경우 : 아에 못떨어지는 경우
     */
}
