// 특정 문자를 사이에 두고 입력 - 입력받아 출력 2
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("-");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print(a);
        System.out.print(b);
    }
}