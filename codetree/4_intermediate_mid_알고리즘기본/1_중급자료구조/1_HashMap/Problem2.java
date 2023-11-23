import java.util.Scanner;
import java.util.HashMap;

// 숫자 등장 횟수 - 큰 수를 카운팅 정렬할 때, HashMap활용
public class Problem2 {
    public static int n, m;

    public static void main(String[] args) {
        // 10^9까지 카운팅 정렬을 하기엔 메모리를 너무 많이 차지하게 된다. -> HashMap활용하자!
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(map.containsKey(x)) {
                int cnt = map.get(x);
                map.put(x, cnt + 1);
            } else
                map.put(x, 1);
        }

        for(int i = 0; i < m; i++) {
            int q = sc.nextInt();
            if(map.containsKey(q))
                System.out.print(map.get(q) + " ");
            else
                System.out.print(0 + " ");
        }
    }
}