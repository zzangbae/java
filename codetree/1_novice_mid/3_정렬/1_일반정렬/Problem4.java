import java.util.Scanner;
import java.util.Arrays;

// Top K 구하기
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        Arrays.sort(arr);
        System.out.println(arr[k - 1]);
    }
}