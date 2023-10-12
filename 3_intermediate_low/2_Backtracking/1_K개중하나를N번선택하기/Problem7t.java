import java.util.*;

/**
 * 알파벳과 사칙연산 t
 */
public class Problem7t {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 6;

    public static int n = 6;
        
    public static String expression;
    public static int[] num = new int[MAX_N];
    public static int ans = INT_MIN;

    public static int conv(int idx) {
        return num[expression.charAt(idx) - 'a'];
    }

    public static int calc() {
        int length = expression.length();
        int value = conv(0);
        for(int i = 2; i < length; i += 2) {
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
        if(cnt == n) {
            ans = Math.max(ans, calc());
            return;
        }

        // a ~ f까지 모든 값에 대해서 백트래킹 수행
        for(int i = 1; i <= 4; i++) {
            num[cnt] = i;
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
