import java.util.*;

/**
 * 배열의 특정 위치 찾기2
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++)
            arr[i] = sc.nextInt();
        
        int sumEven = 0;
        int sumOdd = 0;
        for(int i = 0; i < 10; i++) {
            if(i % 2 == 0)
                sumEven += arr[i];
            else
                sumOdd += arr[i];
        }

        if(sumEven > sumOdd)
            System.out.print(sumEven - sumOdd);
        else
            System.out.print(sumOdd - sumEven);
    }
}