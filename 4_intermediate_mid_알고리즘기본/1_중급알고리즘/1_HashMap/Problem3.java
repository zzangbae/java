import java.util.*;

/**
 * 가장 많은 데이터 : 문자열을 마치 Array의 Index처럼 사용하기
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 해쉬맵 : key는 문자열, value는 나온 횟수
        HashMap<String, Integer> map = new HashMap<>();
        int maxV2 = 0;
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
            // 여기서 바로 값을 생신할 수도 있음
            maxV2 = Math.max(maxV2, map.get(s));
        }

        int maxV = 0;
        Iterator keySetIterator = map.keySet().iterator();
        // 해쉬코드 순회하면서 가장 큰 값 찾기
        while(keySetIterator.hasNext()) {
            String k = keySetIterator.next().toString();
            maxV = Math.max(maxV, map.get(k));
        }
        System.out.println(maxV);
        System.out.println(maxV2);
    }
}
