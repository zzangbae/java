import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int l1 = s1.length();
        int l2 = s2.length();
        for(int i = 0; i < l1; i++) {
            if(s1.charAt(i) != ' ')
                System.out.print(s1.charAt(i));
        }
        for(int i = 0; i < l2; i++) {
            if(s2.charAt(i) != ' ')
                System.out.print(s2.charAt(i));
        }
    }    
}
