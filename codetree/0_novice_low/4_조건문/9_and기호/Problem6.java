// and 기호 - 세 수의 중간값
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(b > a && b < c)
            System.out.println(1);
        else
            System.out.println(0);
    }
}