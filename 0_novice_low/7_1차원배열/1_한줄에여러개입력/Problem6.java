import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int cnt = 0;
        for(int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] == 0) break;
            cnt++;
        }

        for(int i = cnt - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
