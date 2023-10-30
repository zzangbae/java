import java.util.*;

/**
 * 알파벳과 사칙연산 t식으로 직접 풀기
 */
public class Problem7me {
    public static int MAX_N = 6;
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static String expression;
    public static int[] nums = new int[MAX_N];
    
    public static int n = 6;

    public static int ans = INT_MIN;    // 음수가 나올 수 있으므로

    public static int conv(int idx) {
        return nums[expression.charAt(idx) - 'a'];
    }

    public static int calc() {
        int value = conv(0);
        for(int i = 2; i < expression.length(); i += 2) {
            if(expression.charAt(i - 1) == '+')
                value += conv(i);
            else if(expression.charAt(i - 1) == '-')
                value -= conv(i);
            else
                value *= conv(i);
        }

        return value;
    }

    public static void findMax(int cnt) {
        // 종료조건
        if(cnt == n) {
            ans = Math.max(ans, calc());
            return;
        }

        // 모든 값에 백트래킹
        for(int i = 1; i <= 4; i++) {
            nums[cnt] = i;
            findMax(cnt + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expression = sc.next();

        findMax(0);
        System.out.println(ans);
    }
}
