import java.util.*;

/**
 * 컴퓨터와 함께하는 숫자 게임2
 * 13:22~
 */
public class Problem5 {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static long m, a, b;
    public static int minTime = INT_MAX;
    public static int maxTime = INT_MIN;

    public static int countTime(long t) {
        int cnt = 0;
        long left = 1, right = m;
        while(left <= right) {
            cnt++;
            long mid = (left + right) / 2;
            // 맞추면 게임이 끝난다.
            if(mid == t)
                break;
            
            if(mid < t)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        // 1. 컴퓨터가 1~m이하의 수 선택
        // 2. 사람 A가 숫자를 예측
        // 3. 컴퓨터는 큰지 작은지 알려줌
        // 4. 작거나 같을 경우, 넘어감. 같을 경우 벌칙
        // a~b수를 고른다고 할때, 게임이 가장 적게 지속, 가장 오래 지식할 때
        Scanner sc = new Scanner(System.in);
        m = sc.nextLong();
        a = sc.nextLong();
        b = sc.nextLong();
        // t: target
        for(long t = a; t <= b; t++) {
            // 이진 탐색 횟수 확인
            int time = countTime(t);
            minTime = Math.min(minTime, time);
            maxTime = Math.max(maxTime, time);
        }
        System.out.print(minTime + " " + maxTime);
    }
}
