import java.util.Scanner;
import java.util.HashMap;

public class Problem1 {
    public static int n;
    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            if(s.equals("add")) {
                int k = sc.nextInt();
                int v = sc.nextInt();
                map.put(k, v);
            }
            else if(s.equals("find")) {
                int k = sc.nextInt();
                if(map.containsKey(k))
                    System.out.println(map.get(k));
                else
                    System.out.println("None");
            }
            else if(s.equals("remove")) {
                int k = sc.nextInt();
                map.remove(k);
            }
        }
    }
}