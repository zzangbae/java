import java.util.*;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = new String[10];
        for(int i = 0; i < 10; i++) {
            String s = sc.next();
            strArr[i] = s;
        }

        for(int i = 0; i < 10; i++)
            System.out.println(strArr[i]);
    }    
}
