class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int l = triangle.length;
        int[][] dp = new int[l][];  // 2차원 길이는 지정X
        for(int i = 0; i < l; i++)
            dp[i] = new int[i + 1];
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < l; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            dp[i][i] = triangle[i][i] + dp[i - 1][i - 1];
            for(int j = 1; j < dp[i].length - 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
        for(int i = 0; i < l; i++)
            answer = Math.max(answer, dp[l - 1][i]);
        
        return answer;
    }
}
// dp로 푸는게 옳다.
// 참고로 2차원 길이를 나중에 지정해주는 트릭을 활용할 수 있어야한다.