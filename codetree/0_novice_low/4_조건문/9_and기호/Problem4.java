// and 기호 - 특정 조건 세 정수 비교
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a == Math.min(a, Math.min(b, c)))
            System.out.print(1 + " ");
        else
            System.out.print(0 + " ");
        if(a == b && b == c)
            System.out.println(1);
        else
            System.out.println(0);
    }
}