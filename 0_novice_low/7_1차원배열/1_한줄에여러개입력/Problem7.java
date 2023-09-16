import java.util.*;

/**
 * 10개 입력받기
 */
public class Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int cnt = 0;
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] == 0)
                break;
            cnt++;
            sum += arr[i];
        }
        double avg = (double)sum / cnt;
        System.out.printf("%d %.1f", sum, avg);
    }
}
