// 8:05~8:09
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int l = phone_number.length();
        for(int i = l - 1; i >= 0; i--) {
            if(i >= l - 4)
                answer = phone_number.charAt(i) + answer;
            else
                answer = '*' + answer;
        }
        return answer;
    }
}