import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

// HashMap 낮은 지점들
public class Problem11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(map.containsKey(x)) {
                int wy = map.get(x);
                if(wy > y)
                    map.put(x, y);
            } else
                map.put(x, y);
        }

        long answer = 0;
        Set<Integer> keySet = map.keySet();
        for(int key : keySet) {
            answer += map.get(key);
        }
        System.out.println(answer);
    }
}