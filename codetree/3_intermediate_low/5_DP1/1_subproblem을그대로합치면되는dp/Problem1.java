import java.util.*;

public class Problem1 {
    public static final int MAX_N = 45;

    public static int n;
    public static int[] memo = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        memo[1] = 1;
        memo[2] = 1;
        for(int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        System.out.println(memo[n]);
    }    
}
