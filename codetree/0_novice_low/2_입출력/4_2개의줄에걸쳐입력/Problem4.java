// 2개의 줄에 걸쳐 입력 - 세 실수의 반올림
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        System.out.printf("%.3f%n", a);
        System.out.printf("%.3f%n", b);
        System.out.printf("%.3f", c);
    }
}