// 사칙연산 - 사칙연산의 다른 표현법 - 길이 변형 후 사각형 넓이 구하기
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        a += 8; b *= 3;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a * b);
    }
}