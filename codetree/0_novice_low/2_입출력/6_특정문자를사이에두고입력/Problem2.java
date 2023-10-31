// 특정 문자를 사이에 두고 입력 - 날짜 변경하여 출력 2
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("-");
        int m = sc.nextInt();
        int d = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(y + "." + m + "." + d);
    }
}