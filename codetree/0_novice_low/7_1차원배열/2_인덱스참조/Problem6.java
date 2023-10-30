import java.util.*;

/**
 * 배열에서 원소의 특징
 */
public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int i;
        for(i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] % 3 == 0) {
                break;
            }
        }
        System.out.println(arr[i - 1]);
    }
}
