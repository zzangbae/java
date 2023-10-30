import java.util.*;

/**
 * 사각형 채우기3
 * 14:56~
 */
public class Problem4 {
    public static final int MAX_N = 1000;
    public static final long MOD = 1000000007;

    public static long n;
    public static long[] dp = new long[MAX_N + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 3 + dp[i - 2] - dp[i - 3]) % MOD;
        }

        System.out.println(dp[n]);
    }
}
