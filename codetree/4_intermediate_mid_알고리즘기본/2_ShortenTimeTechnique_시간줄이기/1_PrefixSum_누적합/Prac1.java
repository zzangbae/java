/**
 * 구간 내 숫자의 합 빠르게 구하기 : 누적합
 */
public class Prac1 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 6, 2, 6, 7, 7, 2};
        int[] prefixSum = new int[8];

        prefixSum[0] = 0;
        for(int i = 1; i <= 7; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        
        // 구간 [2, 5]의 합 = 21
        System.out.println(prefixSum[5] - prefixSum[1]);
        // 구간 [1, 5]의 합 = 24
        System.out.println(prefixSum[5] - prefixSum[0]);
    }
}
/**
 * 구간합을 구할 때 O(N)으로 풀 수 있는 문제이다.
 */
