import java.util.*;

/*
 * 숫자 빠르게 찾기
 * 23:00 ~ 23:07(7분)
 */
public class Problem1 {
    public static final int MAX_N = 100000; // 10만

    public static int n, m;
    public static int[] arr = new int[MAX_N];

    public static void findIdx(int target) {
        int idx = -2;   // 마지막에 +1을 해주기 때문에 -1이 나오게 하기 위해서 -2로 설정
        int left = 0, right = n - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                idx = mid;
                break;
            }

            if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        System.out.println(idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        for(int i = 0; i < m; i++) {
            int target = sc.nextInt();
            findIdx(target);
        }
    }
}
/**
 * 시간복잡도 판단
 * 찾는 시간 O(logN)
 * m번 순회 -> 따라서 최종 시간복잡도 O(MlogN)
 */