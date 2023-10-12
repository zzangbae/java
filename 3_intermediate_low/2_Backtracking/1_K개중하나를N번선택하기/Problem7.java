import java.util.*;

/**
 * 알파벳과 사칙연산
 * 18:55~19:42(47분)
 */
public class Problem7 {
    public static final int MAX_A = 6;
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static ArrayList<Character> chList = new ArrayList<>();
    public static int[] value = new int[MAX_A]; // 알파벳에 들어가는 값을 관리 
    public static String s;
    public static int n;

    public static int ans = INT_MIN;

    public static int calc() {
        // String을 순회하며 값을 반환
        char cs = s.charAt(0);  // cs: charStart
        int result = value[cs - 97];
        
        for(int i = 1; i < s.length(); i += 2) {
            char c1 = s.charAt(i);      // 연산자
            char c2 = s.charAt(i + 1);  // 피연산자
            int v = value[c2 - 97];
            if(c1 == '+')
                result += v;
            else if(c1 == '-')
                result -= v;
            else if(c1 == '*')
                result *= v;
        }
        return result;
    }

    public static void findMaxValue(int cnt, int cnt2) {
        // 종료조건 - 알파벳의 값들이 모두 다 선정되었다면 계산
        if(cnt2 == chList.size()) {
            // 넣은 값들로 계산한다.
            ans = Math.max(ans, calc());
            return;
        }

        // 재귀호출 -> 아래와 같이 하면 a = 1 b =1 , b =1 (이미 a = 1) 중복 -> 시간초과
        // for(int i = cnt; i < chList.size(); i += 2) {
        //     char c = chList.get(i);
        //     for(int j = 1; j <= 4; j++) {
        //         value[c - 97] = j;
        //         findMaxValue(cnt + 2);
        //     }
        // }
        // 재귀 호출
        char c = chList.get(cnt2);
        for(int i = 1; i <= 4; i++) {
            value[c - 97] = i;
            findMaxValue(cnt + 2, cnt2 + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 알파벳이라면
            if(c >= 97 && c <= 102) {
                // 해당값을 포함하지 않았다면
                if(!chList.contains(c)) {
                    chList.add(c);
                }
            }
        }
        n = chList.size();
        findMaxValue(0, 0);
        System.out.println(ans);
    }
}
