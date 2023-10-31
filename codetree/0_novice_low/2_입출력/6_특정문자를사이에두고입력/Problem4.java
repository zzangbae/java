// 특정 문자를 사이에 두고 입력 - 날짜 변경하여 출력
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\.");
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(m + "-" + d + "-" + y);
    }
}