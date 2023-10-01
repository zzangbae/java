import java.util.*;

/**
 * 금 채굴하기
 * 11:55~12:33(38분)
 */
public class Problem4 {
    public static final int MAX_N = 20;
    
    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_N];

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    // 중심점이 (x, y)이고 배율이 k일 때, 금의 갯수
    public static int getGoldCnt(int x, int y, int k) {
        int gold = 0;
        // 내가 처음 푼 풀이방법 : 절댓값 활용 코드
        // for(int w = -k; w <= k; w++) {
        //     int nx = x + w;
        //     int c = k - Math.abs(w);
        //     for(int v = -c; v <= c; v++) {
        //         int ny = y + v;
        //         if(inRange(nx, ny)) {
        //             gold += grid[nx][ny];
        //         }
        //     }
        // }
        // 이런식의 표현도 가능하다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                if(Math.abs(x - i) + Math.abs(y - j) <= k)
                    gold += grid[i][j];
        }

        return gold;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();   // 금 한개당 가격
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // 손해를 보지 않으면서 채굴할 수 있는 가장 많은 금의 개수
        int maxGoldCnt = 0;
        // k를 0~n까지 늘려가면서 완탐을 진행
        for(int k = 0; k <= 2 * (n - 1); k++) {
            int cost = k * k + (k + 1) * (k + 1);
            // 중심 점의 좌표
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    // k와 중심점이 정해졌을 때, 금의 갯수를 판단
                    int goldCnt = getGoldCnt(i, j, k);
                    // 손해가 나지 않는다면
                    if(goldCnt * m - cost >= 0)
                        maxGoldCnt = Math.max(maxGoldCnt, goldCnt);
                }
            }
        }
        System.out.println(maxGoldCnt);
    }
}
