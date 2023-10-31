// 사칙연산 - 2개의 정수를 서로 더하기
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        a += b; b += a;
        System.out.println(a + " " + b);
    }
}