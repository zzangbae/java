import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        for(int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < 10; i++) {
            if(arr[i] >= 250) {
                break;
            }
            sum += arr[i];
            cnt++;
        }
        double avg = (double)sum / cnt;
        
        System.out.printf("%d %.1f", sum, avg);
    }
}
