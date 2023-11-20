// 8:49~9:02(13분)
import java.util.HashMap;
import java.util.Set;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        // 해쉬맵을 활용하여 선수의 인덱스를 빠르게 찾게 하기
        HashMap<String, Integer> map = new HashMap<>();
        int l = players.length;
        for(int i = 0; i < l; i++)
            map.put(players[i], i);
        int ll = callings.length;
        
        for(int i = 0; i < ll; i++) {
            String s = callings[i];
            // 이름불리운 선수의 기존자리
            int idx = map.get(s);
            // 밀린 선수의 이름
            String s2 = players[idx - 1];
            map.put(s2, idx);       // 인덱스 바꿔주기
            map.put(s, idx - 1);    // 인덱스 바꿔주기
            // players도 바꿔주기
            String tmp = players[idx];
            players[idx] = players[idx - 1];
            players[idx - 1] = tmp;
        }
        
        answer = players;
        
        return answer;
    }
}