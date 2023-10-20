import java.util.*;
/**
 * 두 수의 합
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 위치는 상관없다. 주어진 수와 수의 갯수만 알면 된다.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int result = 0;
        Iterator keySetIterator = map.keySet().iterator();
        while(keySetIterator.hasNext()) {
            String keyS = keySetIterator.next().toString();
            Integer key = Integer.parseInt(keyS);
            // 만약 2 * k = key 이면 다른 계산(본인 자리 제외)
            if(2 * key == k) {
                result += map.get(key) * (map.get(key) - 1);
                continue;
            }
            // 더해서 k인 값이 있는지를 확인
            if(map.containsKey(k - key))
                result += map.get(key) * map.get(k - key);
        }
        // (3, 4) (4, 3) 2번체크되므로 나누기 2
        System.out.println(result / 2);
    }    
}
