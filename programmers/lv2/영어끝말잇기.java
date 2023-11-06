import java.util.HashSet;

class Solution {
    
    public static HashSet<String> set = new HashSet<>();
    
    // 안되는 경우 - 1. 한글자 2. 이전사용단어 3. 뒷단어의 마지막 단어와 동일X
    // 1. 한글자보다 많고 2. 이전에 사용단어에 없고 3. 뒷단어의 마지막 단어와 동일 
    public static boolean possible(String currS, String nextS) {
        return nextS.length() > 1 && !set.contains(nextS) && currS.charAt(currS.length() - 1) == nextS.charAt(0);
    }
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        // 뒷단어의 마지막 단어와 동일해야함
        // 이전 사용 단어X
        // 한글자는 인정X
        // 가장 먼저 탈락하는 사람 번호, 몇번째 탈락하는지
        // HashSet을 사용하여 사용단어를 저장 -> public
        String currS = words[0];    // 현재 단어
        set.add(currS);
        
        int cnt = 0;
        // i만 알면, 몇 라운드의 몇번째 사람인지 확인할 수 있다.
        for(int i = 1; i < words.length; i++) {
            String nextS = words[i];
            // 안되는 경우 - 1. 한글자 2. 이전사용단어 3. 뒷단어의 마지막 단어와 동일X
            if(!possible(currS, nextS)) {
                cnt = i + 1;    // 1-index로 변환
                break;
            }
            // 이어지는 경우 - currS변경하기
            set.add(nextS);
            currS = nextS;
        }
        
        if(cnt == 0) {
            answer[0] = 0; answer[1] = 0;   
        }
        // cnt를 통해서 몇번째에 걸렸는지 확인할 수 있다.
        else {
            int round = cnt / n + 1;
            int num = cnt % n;
            if(num == 0) {
                round -= 1;
                num = n;
            }
            answer[0] = num; answer[1] = round;
        }
        return answer;
    }
}