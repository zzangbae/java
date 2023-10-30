import java.util.*;

/*
 * 양수 직사각형의 최대 크기
 * 1:46~1:55(9분)
 */
public class Problem7 {
    public static final int MAX_NUM = 20;

    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    
    public static int allPlusAndReturn(int r1, int c1, int r2, int c2) {
        int result = 0;
        for(int i = r1; i <= r2; i++) {
            for(int j = c1; j <= c2; j++) {
                if(grid[i][j] <= 0)
                    return -1;
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int ans = -1;
        // 모든 값이 양수로만 이루어져 있는 직사각형 중 최대 크기
        // 그런 직사각형이 없다면 -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = i; k < n; k++) {
                    for(int l = j; l < m; l++) {
                        // 모든 값이 양수로 이루어져있는지 판단하고, -값이 있다면 -1을 반환한다.
                        int tmp = allPlusAndReturn(i, j, k, l);
                        ans = Math.max(ans, tmp);
                    }
                }
            }
        }

        System.out.println(ans);
    }    
}
