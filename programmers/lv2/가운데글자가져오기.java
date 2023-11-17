class Solution {
    public String solution(String s) {
        String answer = "";
        int l = s.length();
        int idx = l / 2;
        answer = l % 2 == 1 ? s.substring(idx, idx + 1) : s.substring(idx - 1, idx + 1);

        return answer;
    }
}