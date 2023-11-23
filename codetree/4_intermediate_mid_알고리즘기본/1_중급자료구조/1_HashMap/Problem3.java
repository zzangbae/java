import java.util.Scanner;
import java.util.HashMap;

// 문자열을 Array Index처럼 활용하기 -> HashMap
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        int maxCnt = 1;
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            if(map.containsKey(s)) {
                int cnt = map.get(s);
                map.put(s, cnt + 1);
                if(cnt + 1 > maxCnt)
                    maxCnt = cnt + 1;
            } else
                map.put(s, 1);
        }
        System.out.println(maxCnt);
    }
}