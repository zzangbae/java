import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int l = 0;
        for(int i = 0; i < 10; i++) {
            String s = sc.next();
            l += s.length();
        }
        System.out.println(l);
    }    
}
