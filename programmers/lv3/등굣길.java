// 12:10~12:34(24분)

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long[][] dp = new long[n][m];
        // 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수
        // 먼저 puddle위치를 -1로 설정하기
        for(int[] puddle : puddles) {
            int y = puddle[0] - 1;
            int x = puddle[1] - 1;
            dp[x][y] = -1;
        }
        // dp구성하기
        dp[0][0] = 1;   // 시작점 1로 찍어주기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 만약 구덩이라면 스킵
                if(dp[i][j] == -1)
                    continue;
                boolean a = i - 1 >= 0 && dp[i - 1][j] != -1;
                boolean b = j - 1 >= 0 && dp[i][j - 1] != -1;
                if(a && b)
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                else if(a && !b)
                    dp[i][j] = dp[i - 1][j] % 1000000007;
                else if(!a && b)
                    dp[i][j] = dp[i][j - 1] % 1000000007;
            }
        }
        
        answer = (int)dp[n - 1][m - 1];
        return answer;
    }
}
// -> 효율성측면: 10억으로 나누는 연산이 한번만 이루어져야한다.