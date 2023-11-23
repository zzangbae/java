import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

public class Problem5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();    // 정수와 그 정수의 갯수 
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if(map.containsKey(a)) {
                int cnt = map.get(a);
                map.put(a, cnt + 1);
            } else
                map.put(a, 1);
        }
        int answer = 0;
        // HashMap을 순회
        Set<Integer> keySet = map.keySet();
        for(int key : keySet) {
            if(key == k - key) {
                answer += map.get(key) * (map.get(key) - 1);
            } else {
                if(map.containsKey(k - key)) {
                    answer += map.get(key) * map.get(k - key);
                }
            }
        }
        System.out.println(answer / 2); // 중복처리
    }
}