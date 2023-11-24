import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int l = phone_book.length;
        HashMap<String, Integer> map = new HashMap<>();
        // HashMap에 미리 넣기 -> 먼저 나온 것들이 접두사인 경우만 체크함
        for(int i = 0; i < l; i++) {
            String s = phone_book[i];
            map.put(s, i);
        }
        
        for(int i = 0; i < l; i++) {
            String s = phone_book[i];
            int sl = s.length();
            String tmp = "";
            boolean finish = false;
            for(int j = 0; j < sl; j++) {
                char c = s.charAt(j);
                tmp += c;
                // 자기 자신은 제외하고 접두어가 있는지 알아야함
                if(map.containsKey(tmp) && !s.equals(tmp)) {
                    answer = false;
                    finish = true;
                    break;
                }
            }
            if(finish)
                break;
        }
        return answer;
    }
}