import java.util.*;

/**
 * Lower bound, Upper bound
 * 내가 찾는 값이 여러개가 있는 경우
 * Lower bound: 원하는 target이상의 값이 최초로 나오는 위치
 * Upper bound: 원하는 target을 초과하는 값이 최초로 나오는 위치
 * Upper Bound - Lower Bound == 배열 내 수의 갯수
 * Lower Bound와 Upper Bound가 같으면 배열 내 target값이 없음
 * Custom Bound : target보다 같거나 작은 숫자들이 있는 위치 중 가장 큰 위치
 */
public class Prac2 {

    public static int n = 13;
    public static int[] arr = new int[]{23, 34, 36, 41, 45, 45, 45, 57, 64, 72, 76, 81, 89};
    public static int target = 45;

    public static int findLowerBound() {
        int left = 0, right = n - 1;
        int minIdx = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                right = mid - 1;    // 왼쪽으로 이동
                minIdx = Math.min(minIdx, mid);
            }
            else
                left = mid + 1;
        }
        return minIdx;
    }

    public static int findUpperBound() {
        int left = 0, right = n - 1;
        int minIdx = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            // 왼쪽에 더 가능성이 있음
            if(arr[mid] > target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else
                left = mid + 1;
        }
        return minIdx;
    }

    public static int findCustomBound() {
        int left = 0, right = n - 1;
        int maxIdx = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] <= target) {
                left = mid + 1;
                maxIdx = Math.max(maxIdx, mid);
            }
            else
                right = mid - 1;
        }
        return maxIdx;
    }

    public static int findCustomBound2() {
        int left = 0, right = n - 1;
        int maxIdx = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] < target) {
                left = mid + 1;
                maxIdx = Math.max(maxIdx, mid);
            }
            else
                right = mid - 1;
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        int lowerBound = findLowerBound();
        int upperBound = findUpperBound();
        int customBound = findCustomBound();
        int custom2Bound = findCustomBound2();
        System.out.println(lowerBound + " " + upperBound + " " + customBound);
        System.out.println("타겟의 갯수: " + (upperBound - lowerBound));
        System.out.println(custom2Bound);
    }
}
