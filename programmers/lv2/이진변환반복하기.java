// 00:59~1:27(28분)
class Solution {
    public static String makeString(int c) {
        String result = "";
        while(c != 1) {
            int d = c % 2;
            result = d + result;
            c /= 2;
        }
        result = "1" + result;
        return result;
    }
    
    public int[] solution(String s) {
        int zeroCnt = 0;    // 제거된 0의 갯수
        int cnt = 0;    // 이진 변환 횟수
        String tmp = "";
        while(true) {
            cnt++;
            // 1. tmp의 모든 0을 제거
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0')
                    zeroCnt++;
                else
                    tmp += '1';
            }
            // 2. 2진법으로 표현
            int c = tmp.length();
            // c를 이진법으로 표현하기
            String cStr = makeString(c);   
            // 이제 s는 cStr가 되고, tmp는 s가 된다.
            s = cStr;
            // 1이 된다면 중지
            if(s.equals("1"))
                break;
            tmp = "";
        }
        int[] answer = {cnt, zeroCnt};
        return answer;
    }
}