import java.util.*;

/**
 * 서로 다른 BST 개수 세기
 * 16:10~17:46(해설 보고품..)
 */
public class Problem5 {
    public static final int MAX_N = 19;

    public static int n;
    public static int[] dp = new int[MAX_N + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        System.out.println(dp[n]);
    }
}
