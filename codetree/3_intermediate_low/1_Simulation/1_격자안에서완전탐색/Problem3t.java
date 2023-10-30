import java.util.*;

public class Problem3t {
    public static final int MAX_NUM = 200;

    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];

    // 가능한 모양
    public static int[][][] shapes = new int[][][]{
        {{1, 1, 0},
        {1, 0, 0},
        {0, 0, 0}},

        {{1, 1, 0},
        {0, 1, 0},
        {0, 0, 0}},

        {{1, 0, 0},
        {1, 1, 0},
        {0, 0, 0}},

        {{0, 1, 0},
        {1, 1, 0},
        {0, 0, 0}},

        {{1, 1, 1},
        {0, 0, 0},
        {0, 0, 0}},

        {{1, 0, 0},
        {1, 0, 0},
        {1, 0, 0}}
    };

    // 주어진 위치에 대하여 가능한 모든 모양을 탐색하여 최대 합을 반환하기
    public static int getMaxSum(int x, int y) {
        int maxSum = 0;

        for(int i = 0; i < 6; i++) {
            boolean isPossible = true;
            int sum = 0;
            for(int dx = 0; dx < 3; dx++)
                for(int dy = 0; dy < 3; dy++) {
                    if(shapes[i][dx][dy] == 0) continue;
                    if(x + dx >= n || y + dy >= m) isPossible = false;
                    else sum += grid[x + dx][y + dy];
                }
            
            if(isPossible)
                maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int ans = 0;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                ans = Math.max(ans, getMaxSum(i, j));

        System.out.println(ans);
    }    
}
