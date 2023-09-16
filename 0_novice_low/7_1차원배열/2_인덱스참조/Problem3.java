import java.util.*;

/**
 * 배열의 특정 위치 찾기 3
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int idx = 0;    // 0이 나온 인덱스
        for(int i = 0; i < 100; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] == 0) {
                idx = i;
                break;
            }
        }
        System.out.println(arr[idx - 3] + arr[idx - 2] + arr[idx - 1]);
    }
}
