class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long small = a < b ? a : b; // -> 오버플로우 방지
        long big = a > b ? a : b;
        answer = (small + big) * (big - small + 1);
        answer /= 2;
        return answer;
    }
}