// 비교 연산자와 조건문 - 4가지 관계연산자
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a >= b ? 1 : 0);
        System.out.println(a > b ? 1 : 0);
        System.out.println(b >= a ? 1 : 0);
        System.out.println(b > a ? 1 : 0);
    }
}