import java.util.*;

public class Solution {
    
    public int solution(int n) {
        int ans = 0;
        // 한번에 k칸을 앞으로 점프 - k만큼의 건전지 듦
        // 현재까지 온거리 x2에 해당하는 위치로 순간이동 - 건전지x
        // 점프 이동 최소
        // 건전지 사용량을 반환하라
        // 10억을 다룰 수 있는 방법이 뭐가 있을까...?
        // int[] dp = new int[n + 1];
        // dp[1] = 1;
        // for(int i = 2; i <= n; i++) {
        //     int q = i / 2;
        //     int d = i % 2;
        //     dp[i] = dp[q] + d;
        // }
        // ans = dp[n];
        // => 2진수로 변환했을 때의 1의 갯수다.
        while(n != 1) {
            ans += n % 2;
            n /= 2;
        }
        ans += 1;
        
        return ans;
    }
}