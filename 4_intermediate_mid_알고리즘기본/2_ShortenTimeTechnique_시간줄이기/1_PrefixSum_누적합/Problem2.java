import java.util.Scanner;

/**
 * 정수 n개의 합
 * 1이상 100이하의 숫자로만 이루어진 n*n 크기의 2차원 격자 상태가 주어졌을 때,
 * k * k 크기의 정사각형이 격자를 벗어나지 않게 잡았을 때 정사각형 내 숫자들의 합이 최대가 되도록하는 프로그램 작성
 */
public class Problem2 {
    public static final int MAX_N = 500;
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static int n, k;
    public static int[][] arr = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] prefixSum = new int[MAX_N + 1][MAX_N + 1];

    public static int ans = INT_MIN;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                arr[i][j] = sc.nextInt();
        
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + arr[i][j];
        
        for(int i = k; i <= n; i++)
            for(int j = k; j <= n; j++)
                ans = Math.max(ans, prefixSum[i][j] - prefixSum[i - k][j] - prefixSum[i][j - k] + prefixSum[i - k][j - k]);
            
        System.out.println(ans);
    }
}