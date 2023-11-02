class Solution {
    
    public static int[] dp;
        
    public int solution(int n) {
        int answer = 0;
        dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        
        answer = dp[n];
        return answer;
    }
}