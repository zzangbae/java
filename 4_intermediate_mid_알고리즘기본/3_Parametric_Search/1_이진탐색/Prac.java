import java.util.*;

/**
 * 이진탐색
 */
public class Prac {
    public static void main(String[] args) {
        int n = 13, target = 45;
        // 배열은 정렬되어 있어야함
        int[] arr = new int[]{23, 34, 36, 41, 45, 49, 52, 57, 64, 72, 76, 81, 89};

        int idx = -1;
        
        int left = 0, right = n - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                idx = mid;
                break;
            }
            
            // 타겟 값보다, 미드가 작다면 오른쪽으로 이동해야함 -> left를 이동
            if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println(idx);    // 만약 45가 없다면 -1이 그대로 나오게 된다.
    }    
}
