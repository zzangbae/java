// 11:29~11:58(29분)
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int num = 27;   // 사전에 추가되는 번호
        
        for(int i = 65; i <= 90; i++)
            map.put(Character.toString((char)i), i - 64);    
        
        int l = msg.length();
        for(int i = 0; i < l; i++) {
            String w = "";
            char c = 'a';
            // 사전에 현재 입력과 가장 일치하는 가장 긴 문제열 찾기
            for(int j = i; j < l; j++) {
                c = msg.charAt(j);
                if(!map.containsKey(w + c))
                    break;
                w += c;
            }
            // 글자 당기기 -> k a ka o 로 가기위함. 안그러면 k a ka a로 가게됨
            if(w.length() > 1)
                i += w.length() - 1;
            
            // 앞까지 글자 출력
            al.add(map.get(w));
            // 사전 추가하기
            map.put(w + c, num++);
        }
        int aLength = al.size();
        answer = new int[aLength];
        for(int i = 0; i < aLength; i++)
            answer[i] = al.get(i);
        
        return answer;
    }
}