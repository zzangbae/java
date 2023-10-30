import java.util.*;

/**
 * 알파벳과 사칙연산 다시풀기
 * 14:40~14:50(10분)
 */
public class Problem7re {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int ALPHA_NUM = 6;
    
    public static int n = 6;

    public static int ans = INT_MIN;
    public static String s;
    public static int[] nums = new int[ALPHA_NUM];

    // s를 통해서 계산하기
    public static int calc() {
        int value = nums[s.charAt(0) - 'a'];
        for(int i = 2; i < s.length(); i += 2) {
            if(s.charAt(i - 1) == '+')
                value += nums[s.charAt(i) - 'a'];    
            else if(s.charAt(i - 1) == '-')
                value -= nums[s.charAt(i) - 'a'];
            else
                value *= nums[s.charAt(i) - 'a'];
        }
        return value;
    }

    public static void findMaxSum(int cnt) {
        // 종료조건: 알파벳마다 숫자가 다 부여되었다면 종료
        if(cnt == n) {
            ans = Math.max(ans, calc());
            return;
        }

        // 재귀호출
        for(int i = 1; i <= 4; i++) {
            nums[cnt] = i;
            findMaxSum(cnt + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        findMaxSum(0);

        System.out.println(ans);
    }    
}
