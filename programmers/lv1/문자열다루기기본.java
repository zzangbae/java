class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        // 숫자로만 이루어져있는지 확인하는 함수
        int l = s.length();
        if(l != 4 && l != 6)
            return false;
        
        for(int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if(c > '9' || c < '0') {
                return false;
            }
        }
        answer = true;
        return answer;
    }
}