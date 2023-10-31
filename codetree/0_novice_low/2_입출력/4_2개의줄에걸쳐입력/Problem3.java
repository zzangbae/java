// 2개의 줄에 걸쳐 입력 - 실수 입력받아 계산
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        System.out.printf("%.2f", a + b);
    }
}