// 특정 문자를 사이에 두고 입력 - 전화번호 바꾸기
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("-");
        String a = sc.next();
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(a + "-" + y + "-" + x);
    }
}