// 1:30~1:40(10분)
class Solution {
    public int solution(int n) {
        int answer = 1; // 기본적으로 자기자신만으로 연속할 수 있음
        // 자연수 n을 **연속한 자연수들로 표현하는 방법이 여러개
        // 자연수 n을 표현하는 방법을 찾기
        int k = 1;  // 시작점
        int total = 0;
        while(k <= n / 2) {
            int i = k;
            while(total < n) {
                total += i;
                i++;
            }
            if(total == n)
                answer++;
            total = 0;
            k++;
        }
        return answer;
    }
}