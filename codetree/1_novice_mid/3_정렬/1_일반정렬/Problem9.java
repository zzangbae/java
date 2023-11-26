import java.util.Scanner;
import java.util.Arrays;

// 중앙값 계산2 - n개의 숫자가 주어짐 -> 순서대로 읽다가 홀수번째 원소 주어질 때, 입력받은 값의 중앙값 출력
public class Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            // 홀수번째 원소가 주어질 때, 정렬 및 출력수행
            if(i % 2 == 0) {
                Arrays.sort(arr, 0, i + 1);
                System.out.print(arr[i / 2] + " ");
            }
        }
    }
}