// 특정 문자를 사이에 두고 입력 - 1시간 뒤 시간 출력
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(":");
        int h = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(h + 1 + ":" + m);
    }
}