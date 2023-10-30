import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int s1Len = s1.length();
        int s2Len = s2.length();

        String tmp1 = "";
        String tmp2 = "";

        for(int i = 0; i < s1Len; i++) {
            char c = s1.charAt(i);
            if(c >= '0' && c <= '9')
                tmp1 += c;
        }
        for(int i = 0; i < s2Len; i++) {
            char c = s2.charAt(i);
            if(c >= '0' && c <= '9')
                tmp2 += c;
        }

        int str1Int = Integer.parseInt(tmp1);
        int str2Int = Integer.parseInt(tmp2);

        System.out.println(str1Int + str2Int);
    }
}
