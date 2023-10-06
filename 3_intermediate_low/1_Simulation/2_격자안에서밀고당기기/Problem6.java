import java.util.*;

/**
 * 최단 Run Length 인코딩
 * 12:37~13:13(36분)
 */
public class Problem6 {
    
    public static String s;

    // 압축한 문자열을 구하기
    public static String runLen(String s) {
        String result = "";
        int cnt = 1;
        char c = s.charAt(0);   // 가장 마지막 글자를 저장
        result += c;    // 맨 첫글자를 가져옴
        
        // 경제에서 생기는 문제
        if(s.length() == 1) {
            result += cnt;
            return result;
        }

        for(int i = 1; i < s.length(); i++) {
            
            // 만약 새로운 글자가 기존의 글자와 다르다면 : ab인 상황
            if(s.charAt(i) != c) {
                // 숫자 넣어주기
                result += cnt;
                // c바꿔주기
                c = s.charAt(i);
                // cnt초기화
                cnt = 1;
                // result에 c 넣어주기
                result += c;

                // 만약 다른글자가 마지막에 들어온 상황이었다면 -> ab인데 b가 마지막
                if(i == s.length() - 1) {
                    result += cnt;
                }
            }
            // 만약 새로운 글자가 기존의 글자와 같다면 : aa인 상황
            else {
                // 숫자 올려주기
                cnt++;
                // 만약 마지막이었다면 : aa가 마지막
                if(i == s.length() - 1) {
                    result += cnt;
                }
            }
        }


        return result;
    }

    // 전역 변수 s를 쉬프트 시킨다.
    public static void shift() {
        String result = "";
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            result += s.charAt(i);
        }
        result += c;
        s = result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        int result = Integer.MAX_VALUE;
        int l = s.length();
        // 문자열 길이만큼 쉬프트 하게 된다.(오른쪽 쉬프트)
        while(l-- > 0) {
            // Run Length를 구하기
            String sT = runLen(s);
            result = Math.min(result, sT.length());
            // 쉬프트하기
            shift();
        }
        System.out.println(result);
    }    
}
/**
 * 실수한 부분 : 경계조건
 */