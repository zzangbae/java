// 사칙연산 - 합과 차의 나눗셈
import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.printf("%.2f", (double)(a + b) / (a - b));
    }
}