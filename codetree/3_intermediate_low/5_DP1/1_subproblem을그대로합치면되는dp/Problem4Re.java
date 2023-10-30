import java.util.*;

public class Problem4Re {
    public static final int MAX_N = 1000;
    public static final int MOD = 1000000007;

    public static int n;
    public static long[] dp = new long[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3) % MOD;
            for(int j = i - 3; j >= 0; j--) {
                dp[i] = (dp[i] + (dp[j] * 2) % MOD) % MOD;
            }
        }

        System.out.println(dp[n]);
    }    
}
