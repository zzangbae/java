import java.util.*;
/**
 * 행복한 수열의 갯수
 * 13:48~14:08(20분)
 */
public class Problem2 {
    public static final int MAX_N = 100;

    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_N];

    public static void main(String[] args) {
        // 행복한 수열 : 연속하여 m개 이상 동일한 원소가 나오는 순간이 존재하는 수열
        // 출력 : 행복한 수열의 수를 출력
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // 가로로 행복한 수열의 수를 세기
        int result1 = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j + m - 1< n; j++) {
                int c = grid[i][j];
                boolean isHappy = true;
                for(int k = 1; k < m; k++) {
                    if(grid[i][j + k] != c) {
                        isHappy = false;
                        break;
                    }
                }
                if(isHappy) {
                    result1++;
                    break;
                }
            }
        }

        // 세로로 행복한 수열의 수를 세기
        int result2 = 0;
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n; i++) {
                int c = grid[i][j];
                boolean isHappy = true;
                for(int k = 1; k < m; k++) {
                    if(grid[i + k][j] != c) {
                        isHappy = false;
                        break;
                    }
                }
                if(isHappy) {
                    result2++;
                    break;
                }
            }
        }
        int result = result1 + result2;
        System.out.println(result);
    }
}
