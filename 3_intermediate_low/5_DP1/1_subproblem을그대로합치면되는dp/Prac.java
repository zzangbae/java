import java.util.*;

/**
 * 피보나치 수열
 */
public class Prac {

    public static int n;

    public static int dpRecur(int n) {
        if(n == 1 || n == 2)
            return 1;
        
        return dpRecur(n - 1) + dpRecur(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int result = dpRecur(n);
        System.out.println(result);
    }    
}
