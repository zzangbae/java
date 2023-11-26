import java.util.Scanner;
import java.util.Arrays;

// 두 개의 동일한 수열 -> 두 배열이 같은 원소로 이루어져있는지를 판단
public class Problem5 {
    public static void main(String[] args) {
        // 두 수열을 정렬하고, 비교하면 빠르다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr2[i] = sc.nextInt();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0; i < n; i++)
            if(arr1[i] != arr2[i]) {
                System.out.println("No");
                return;
            }
        System.out.println("Yes");
    }
}