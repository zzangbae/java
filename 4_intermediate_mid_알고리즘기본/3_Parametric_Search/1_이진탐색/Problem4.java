import java.util.*;

/**
 * 선분 위의 점
 * 12:25~
 * 이분 탐색 알 수 있는 것 : 오름차순, 엄청나게 많은 입력값(10만up)
 */
public class Problem4 {
    public static final int MAX_N = 100000;

    public static int n, m;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static int lower(int target) {
        int left = 0, right = n - 1;
        int minIdx = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr.get(mid) >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else
                left = mid + 1;
        }
        return minIdx;
    }

    public static int upper(int target) {
        int left = 0, right = n - 1;
        int minIdx = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr.get(mid) > target) {
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
        // n개의 점, m개의 선분
        // 각 선분 위에 몇개의 점이 있는지 구하여라
        // 한개의 변수를 log로 줄여야한다. -> 시간복잡도
        // 이분 탐색을 통해서 해당 값이 있는지 확인할 수 있다.
        for(int i = 0; i < n; i++)
            arr.add(sc.nextInt());
        
        Collections.sort(arr);

        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            // s를 기준으로 lower
            // e를 기준으로 upper
            System.out.println(upper(e) - lower(s));
        }
    }
}
/**
 * 이진탐색 -> 정렬이 꼭 필요하다!
 * Arrays.sort(arr); 를 활용하면 arr정렬이 가능하다!
 */