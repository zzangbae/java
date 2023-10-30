import java.util.*;

/**
 * 특정 위치의 숫자
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(arr[2] + arr[4] + arr[9]);
    }
}
