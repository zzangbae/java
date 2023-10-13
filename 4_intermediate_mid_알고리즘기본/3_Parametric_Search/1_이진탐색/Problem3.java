import java.util.*;

/**
 * 가장 먼저 나오는 숫자
 * 00:09~00:16(7분)
 * 이분 탐색을 눈치챌 수 있는 것 => 오름차순되어 있음. 즉, 정렬됨
 */
public class Problem3 {
    public static final int MAX_N = 100000;

    public static int n, m;
    public static int[] arr = new int[MAX_N];

    public static void findLower(int target) {
        int left = 0, right = n - 1;
        int minIdx = n;
        boolean isHere = false;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                if(arr[mid] == target)
                    isHere = true;
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else
                left = mid + 1;
        }
        if(!isHere)
            minIdx = -2;
        System.out.println(minIdx + 1); // 0에서 인덱스 시작하므로 +1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        // 주어진 x가 최초로 등장하는 위치 -> Lower Bound를 찾아라
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            findLower(x);
        }
    }
}
