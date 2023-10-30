import java.util.*;

/**
 * 최고의 33위치 13:32~13:40(8분)
 */
public class Problem1 {
    public static final int MAX_N = 20;

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int maxCnt = 0;
        for(int i = 0; i + 2 < n; i++) {
            for(int j = 0; j + 2 <n; j++) {
                int tmpCnt = 0;
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        tmpCnt += grid[i + k][j + l];
                    }
                }
                maxCnt = Math.max(maxCnt, tmpCnt);
            }
        }
        System.out.println(maxCnt);
    }
}
