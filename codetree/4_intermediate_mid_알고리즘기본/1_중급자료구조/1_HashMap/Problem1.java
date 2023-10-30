import java.util.*;

/**
 * HashMap 기본
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            if(s.equals("add")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                map.put(a, b);
            }
            else if(s.equals("remove")) {
                int a = sc.nextInt();
                map.remove(a);
            }
            else if(s.equals("find")) {
                int a = sc.nextInt();
                if(map.containsKey(a)) {
                    System.out.println(map.get(a));
                } else {
                    System.out.println("None");
                }
            }
        }
    }
}
