import java.util.*;

/**
 * 정수 n개의 합 2
 * 크기가 n인 수열이 주어졌을 때, 이 중 연속하는 k개의 원소들의 합 중 가장 큰 합
 */
public class Problem1 {
    public static final int MAX_N = 100000;

    public static int n, k;
    public static int[] arr = new int[MAX_N];
    public static int[] prefixSum = new int[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        prefixSum[0] = arr[0];
        for(int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        
        int maxSum = prefixSum[k - 1];
        for(int i = k; i < n; i++)
            maxSum = Math.max(maxSum, prefixSum[i] - prefixSum[i - k]);

        System.out.println(maxSum);
    }
}