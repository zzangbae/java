// and, or 혼합 - 장학금
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int l = sc.nextInt();
        if(m < 90)
            System.out.println(0);
        else if(l >= 95)
            System.out.println(100000);
        else if(l >= 90)
            System.out.println(50000);
        else
            System.out.println(0);
    }
}