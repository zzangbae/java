// 공백을 사이에 두고 입력 - 입력받은 값 교체하기
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println(a + " " + b);
    }
}