import java.util.*;

public class Problem5_re {
    public static final int MAX_N = 19;

    public static int n;
    public static int[] dp = new int[MAX_N + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= i - 1; j++) {
                dp[i] += dp[i - j - 1] * dp[j];
            }
        }
        System.out.println(dp[n]);
    }    
}
