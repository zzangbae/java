import java.util.*;

/**
 * 숫자의 개수
 * 11:54~12:03(9분)
 */
public class Problem2 {
    public static final int MAX_N = 100000;

    public static int n, m;
    public static int[] arr = new int[MAX_N];

    public static int findUpper(int target) {
        int left = 0, right = n - 1;
        int minIdx = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            // arr[mid]가 target보다 큰 동안 왼쪽으로 이동 : 왼쪽에 가능성이 더 있음
            if(arr[mid] > target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else
                left = mid + 1;
        }
        return minIdx;
    }

    public static int findLower(int target) {
        int left = 0, right = n - 1;
        int minIdx = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            // arr[mid]가 타겟과 같거나 크다면 더 왼쪽에 Lower Bound가 있을 가능성이 있음
            if(arr[mid] >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else
                left = mid + 1;
        }
        return minIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // 물론 카운트 정렬로 해도 된다..하지만 그 수가 10억을 넘어간다면?? 카운팅 정렬로는 안된다.
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        for(int i = 0; i < m; i++) {
            int target = sc.nextInt();
            System.out.println(findUpper(target) - findLower(target));
        }
    }
}
