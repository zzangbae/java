import java.util.*;

/**
 * Tabulation : 테이블만들어서 해결
 */
public class Prac3 {
    public static final int MAX_N = 46;

    public static int n;
    public static int[] dp = new int[MAX_N + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        System.out.println(dp[n]);
    }
}
