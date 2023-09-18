import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

/**
 * 대응되는 수와 문자
 */
public class Problem4 {
    public static int MAX_N = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[MAX_N + 1];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, i + 1);
            arr[i + 1] = s;
        }

        // 입력값의 타입에 따라 다른 결과 출력
        // 문자로 찾을 때는 -> 해쉬로
        // 숫자로 찾을 때는 -> 배열로
        for(int i = 0; i < m; i++) {
            String s = sc.next();
            // 키였던 경우
            if(map.containsKey(s)) {
                System.out.println(map.get(s));
            } else {
                // 숫자였던 경우, 숫자로 바꾸고 인덱스 값으로 찾는다.
                System.out.println(arr[Integer.parseInt(s)]);
            }
        }
    }
}
