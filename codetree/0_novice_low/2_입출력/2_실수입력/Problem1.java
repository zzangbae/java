// 실수 입력 - 실수 받아 그대로 출력
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        System.out.printf("%.2f", n);
    }
}