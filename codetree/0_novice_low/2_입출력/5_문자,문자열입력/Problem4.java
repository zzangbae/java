// 문자, 문자열 입력 - 문자열 순서 바꾸기
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        String temp = s;
        s = t;
        t = temp;
        System.out.println(s);
        System.out.println(t);
    }
}