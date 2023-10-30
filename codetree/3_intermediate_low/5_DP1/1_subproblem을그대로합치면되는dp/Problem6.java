import java.util.*;

/**
 * 사각형 채우기2
 * 15:51~
 */
public class Problem6 {
    public static final int MAX_N = 1000;

    public static int n;
    public static int[] dp = new int[MAX_N];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.println(dp[n]);
    }
}
