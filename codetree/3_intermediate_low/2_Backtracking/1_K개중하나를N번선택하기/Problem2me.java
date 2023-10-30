import java.util.*;

/**
 * 아름다운 수 스스로 풀기
 */
public class Problem2me {
    public static int n;
    public static int result;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static boolean isBeautiful() {
        for(int i = 0; i < arr.size(); i += arr.get(i)) {
            if(i + arr.get(i) - 1 >= n) {
                return false;
            }

            for(int j = i; j < i + arr.get(i); j++) {
                if(arr.get(j) != arr.get(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void countBeautiful(int cnt) {
        if(cnt == n) {
            if(isBeautiful()) {
                result++;
            }
            return;
        }
        for(int i = 1; i <= 4; i++) {
            arr.add(i);
            countBeautiful(cnt + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        countBeautiful(0);
        
        System.out.println(result);
    }
}
