import java.util.*;

public class Problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] strArr = new String[10];
        for(int i = 0; i < 10; i++) {
            strArr[i] = sc.next();
        }

        char c = sc.next().charAt(0);
        int cnt = 0;
        for(int i = 0; i < 10; i++) {
            int l = strArr[i].length();
            if(strArr[i].charAt(l - 1) == c) {
                System.out.println(strArr[i]);
                cnt++;
            }
        }

        if(cnt == 0)
            System.out.println("None");
    }    
}
