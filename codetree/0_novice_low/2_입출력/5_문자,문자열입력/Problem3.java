// 문자, 문자열 입력 - 실수와 문자 받아 출력하기
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        System.out.println(c);
        System.out.printf("%.2f%n", a);
        System.out.printf("%.2f", b);
    }
}