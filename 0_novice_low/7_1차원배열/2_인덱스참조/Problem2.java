import java.util.*;

/**
 * 배열의 특정 위치 찾기
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++)
            arr[i] = sc.nextInt();
        
        int sumOf2 = 0;
        int sumOf3 = 0;
        // 짝수번째로 입력된 값 : 시작1(인덱스), +2씩
        for(int i = 1; i < 10; i += 2) {
            sumOf2 += arr[i];
        }
        int cnt3 = 0;
        // 3의 배수번째로 입력된 값 : 시작2(인덱스), +3씩
        for(int i = 2; i < 10; i += 3) {
            sumOf3 += arr[i];
            cnt3++;
        }
        double avg3 = (double)sumOf3 / cnt3;
        System.out.printf("%d %.1f", sumOf2, avg3);
    }
}
