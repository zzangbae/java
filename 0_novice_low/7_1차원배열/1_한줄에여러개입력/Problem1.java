import java.util.*;

// 원소 10개의 합
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++)
            arr[i] = sc.nextInt();
        
        int sum = 0;
        for(int i = 0; i < 10; i++)
            sum += arr[i];
        
        System.out.println(sum);
    }
}
