import java.util.*;
/**
 * 계단 오르기
 * 14:40~14:47(7분)
 */
public class Problem2 {
    public static final int MOD = 10007;
    public static final int MAX_N = 1000;

    public static int n;
    public static int[] memo = new int[MAX_N + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        memo[0] = 1;
        memo[2] = 1;    // 점화식 초기값
        memo[3] = 1;    // 점호식 초기값
        for(int i = 4; i <= n; i++) {
            memo[i] = (memo[i - 2] + memo[i - 3]) % MOD;
        }
        System.out.println(memo[n]);
    }
}
