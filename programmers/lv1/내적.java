class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int l = a.length;
        for(int i = 0; i < l; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}