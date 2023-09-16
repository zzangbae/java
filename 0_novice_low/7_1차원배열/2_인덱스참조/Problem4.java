import java.util.*;

/**
 * 특정 위치의 문자 2
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = new char[10];
        for(int i = 0; i < 10; i++)
            arr[i] = sc.next().charAt(0);
        
        // 출력
        System.out.print(arr[1] + " " + arr[4] + " " + arr[7]);
    }
}
