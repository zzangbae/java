import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] strArr = new String[10];
        for(int i = 0; i < 10; i++) {
            strArr[i] = sc.next();
        }

        for(int i = 9; i >= 0; i--) {
            System.out.println(strArr[i]);
        }
    }    
}
