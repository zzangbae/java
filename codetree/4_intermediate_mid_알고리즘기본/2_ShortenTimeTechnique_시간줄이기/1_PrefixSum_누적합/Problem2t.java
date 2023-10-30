import java.util.Scanner;

public class Problem2t {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 500;

    public static int[][] arr = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] prefixSum = new int[MAX_N + 1][MAX_N + 1];

    public static int n, k;
    public static int ans = INT_MIN;

    // (x1, y1), (x2, y2) 직사각형 구간 내의 원소의 합을 반환
    public static int getSum(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                arr[i][j] = sc.nextInt();
        
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i][j];
        
        for(int i = 1; i <= n - k + 1; i++)
            for(int j = 1; j <= n - k + 1; j++)
                ans = Math.max(ans, getSum(i, j, i + k - 1, j + k - 1));

        System.out.println(ans);
    }    
}
