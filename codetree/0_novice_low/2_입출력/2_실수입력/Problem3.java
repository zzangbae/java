// 실수 입력 - 실수 입력받아 계산2
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        System.out.printf("%.2f", a + 1.5);
    }
}