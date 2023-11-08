class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int cnt = 1;
        while(true) {
            // 끝내는 조건 - 홀수가 작은 번호 일 경우에만
            if(max == min + 1 && min % 2 == 1)
                break;
            if(max % 2 == 1)
                max = max / 2 + 1;
            else
                max /= 2;
            if(min % 2 == 1)
                min = min / 2 + 1;
            else
                min /= 2;
            cnt++;
        }
        answer = cnt;
        return answer;
    }
}