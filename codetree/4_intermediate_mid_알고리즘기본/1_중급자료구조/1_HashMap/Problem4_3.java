import java.util.Scanner;
import java.util.HashMap;

public class Problem4_3 {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            String s = sc.next();
            map1.put(s, i);
            map2.put(i, s);
        }
        for(int i = 1; i <= m; i++) {
            // 입력값이 무엇인지 모를 때.
            // 먼저 next로 받고 판단하기
            String s = sc.next();
            if('0' <= s.charAt(0) && s.charAt(0) <= '9')
                System.out.println(map2.get(Integer.parseInt(s)));
            else
                System.out.println(map1.get(s));
        }
    }
}