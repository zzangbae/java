import java.util.*;

/**
 * 더 긴 문자열
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 > l2) {
            System.out.println(s1 + " " + l1);
        } else if (l1 == l2) {
            System.out.println("same");
        } else
            System.out.println(s2 + " " + l2);
    }
}
