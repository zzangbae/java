import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        // 최고의 집합
        // 1. 각원소의 합이 s
        // 2. 각 원소의 곱이 최대 - 자연수 n개로 이루어짐(집합)
        // n은 1만
        // s는 1억 -> 최고의 집합이 존재하지 않는 경우 -> [-1]
        if(s < n)
            return new int[]{-1};
        int q = s / n;
        int d = s % n;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(cnt < d) {
                answer[i] = q + 1;
                cnt++;
            }
            else
                answer[i] = q;
        }
        Arrays.sort(answer);
        return answer;
    }
}