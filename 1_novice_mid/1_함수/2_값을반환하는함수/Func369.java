import java.util.*;

public class Func369 {
    public static boolean IsMagic369(int n) {
        return n % 3 == 0 || contains369(n);
    }

    public static boolean contains369(int n) {
        while(n > 0) {
            if(n % 10 == 3 || n % 10 == 6 || n % 10 == 9)
                return true;
            n /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;
        for(int n = a; n <= b; n++)
            if(IsMagic369(n)) cnt++;

        System.out.println(cnt);
    }
}
