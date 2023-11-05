class Solution {
    public long solution(long n) {
        long answer = -1;
        double x = Math.sqrt(n);
        for(long i = 1; i <= x; i++) {
            if(i * i == n) {
                answer = (i + 1) * (i + 1);
                break;
            } 
        }
        
        return answer;
    }
}