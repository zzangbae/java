import java.util.*;

public class Problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[100];    // 최대로 땡겨서 넣는방식

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = n - 1; i >= 0; i--) {
            if(arr[i] % 2 == 0)
                System.out.print(arr[i] + " ");
        }
    }
}
