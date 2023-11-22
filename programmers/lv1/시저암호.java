class Solution {
    public String solution(String s, int n) {
        String answer = "";
        // 소문자, 대문자, 공백으로 이루어짐
        // n은 1이상 25이하인 자연수
        int l = s.length();
        for(int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                answer += ' ';
                continue;
            }
            int k = (int) c;
            // 소문자인 경우
            if(k >= 97 && k <= 122) {
                k += n;
                if(k > 122)
                    k -= 26;
            }
            else if(k >= 65 || k <= 90) {
                k += n;
                if(k > 90)
                    k -= 26;
            }
            answer += (char) k;
        }
        return answer;
    }
}