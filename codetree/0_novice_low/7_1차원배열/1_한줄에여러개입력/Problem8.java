import java.util.*;

/**
 * 배열의 특정 위치 찾기 4
 */
public class Problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int cnt = 0;
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] == 0)
                break;
            if(arr[i] % 2 == 0) {
                sum += arr[i];
                cnt++;
            }
        }

        System.out.println(cnt + " " + sum);
    }
}
