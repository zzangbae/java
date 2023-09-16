import java.util.*;

/**
 * 배열 거꾸로 탐색
 */
public class ReverseTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        for(int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        // 역으로 순회하는 방법1
        for(int i = 9; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 역으로 순회하는 방법2
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[9 - i] + " ");
        }
    }
}