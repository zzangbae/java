import java.util.Scanner;

// 문자열 순회하기
public class Prac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        for(int i = 0; i < str.length(); i++)
            System.out.println(str.charAt(i));
    }
}
