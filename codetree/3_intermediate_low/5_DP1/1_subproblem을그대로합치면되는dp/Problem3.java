import java.util.*;

/**
 * 사각형 채우기
 * 14:48~14:54(6분)
 */
public class Problem3 {
    public static final int MAX_N = 1000;
    public static final int MOD = 10007;

    public static int n;
    public static int[] memo = new int[MAX_N + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // 2 * n 사각형을 채우는 방법의 수를 10,007로 나눈 나머지
        memo[0] = 1;
        memo[1] = 1;    // 풀이에선 여기까지 초기조건
        memo[2] = 2;
        for(int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % MOD;
        }
        System.out.println(memo[n]);
        
    }
}
