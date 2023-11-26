import java.util.Scanner;
import java.util.Arrays;

// 2개씩 그룹짓기 -> 각 그룹에 있는 원소의 합 중 최댓값이 최소가 되도록
public class Problem6 {
    public static void main(String[] args) {
        // 가장 큰 값과 가장 작은 값을 엮어줘야한다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        for(int i = 0; i < 2 * n; i++)
            arr[i] = sc.nextInt();
        
        Arrays.sort(arr);
        int maxSum = -1;
        for(int i = 0; i < n; i++) {
            int tmp = arr[i] + arr[2 * n - 1 - i];
            maxSum = Math.max(maxSum, tmp);
        }
        System.out.println(maxSum);
    }
}