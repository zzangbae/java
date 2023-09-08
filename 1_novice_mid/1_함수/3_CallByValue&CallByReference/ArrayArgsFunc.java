import java.util.*;

// 리시트를 인자로 받는 함수 - 짝수만 2로 나누기
public class ArrayArgsFunc {
    public static final int MAX_N = 100;

    public static int n;
    public static int[] arr = new int[MAX_N];

    public static void modify(int[] arr) {
        for(int i = 0; i < n; i++)
            if(arr[i] % 2 == 0)
                arr[i] /= 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        modify(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
