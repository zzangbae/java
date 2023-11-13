// 8:10~8:24(14분)
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 일정한 금액 지불 -> 10일 회원
        // 회원 대상 한가지 제품 할인 - 하루에 하나씩만 구매 가능
        // 원하는 제품과 수량이 할인하는 날짜와 10일연속 일치는 경우 회원가입
        // 회원 등록 날짜의 총 일수
        int wl = want.length;
        int dl = discount.length;
        int nl = number.length;
        
        // 1. 기준이 되는 해쉬맵을 만든다. - 원하는 물품의 번호와 인덱스 번호를 매칭
        HashMap<String, Integer> hMap = new HashMap<>();
        for(int i = 0; i < wl; i++) {
            String c = want[i];
            hMap.put(c, i);
        }
        
        // 2. discount를 순회하며 tmpCnt를 만든다. - cnt정렬 만들기 
        for(int x = 0; x <= dl - 10; x++) {
            int[] cnt = new int[nl];
            // 10일동안 제품cnt
            for(int i = x; i <= x + 9; i++) {
                String c = discount[i];
                // want에 있는 제품인 경우, cnt추가
                if(hMap.containsKey(c)) {
                    int idx = hMap.get(c);
                    cnt[idx]++;
                }
            }
            // 2-1. number와 비교하기
            boolean flag = true;
            for(int i = 0; i < nl; i++) {
                if(number[i] > cnt[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer++;
        }
        return answer;
    }
}