import java.util.*;

/**
 * 가장 짧은 문자열
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        int maxL = l1;
        int minL = l1;
        if(l2 > maxL) maxL = l2;
        if(l3 > maxL) maxL = l3;
        if(l2 < minL) minL = l2;
        if(l3 < minL) minL = l3;

        System.out.println(maxL - minL);
    }
}
