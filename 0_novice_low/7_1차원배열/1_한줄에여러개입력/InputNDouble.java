import java.util.*;
/**
 * n개의 수 입력 : 실수(double)
 */
public class InputNDouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] arr = new double[n];   // 동적할당(n으로 주어짐. cpp에서는 안됨)
        double sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }
        System.out.println(sum);
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
