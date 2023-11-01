// or 기호 - 둘 중 하나의 배수
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a % 3 == 0 || a % 5 == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }
}