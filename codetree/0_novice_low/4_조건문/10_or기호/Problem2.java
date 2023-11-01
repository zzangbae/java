// or 기호 - 숫자의 조건 여부 3
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a % 13 == 0 || a % 19 == 0)
            System.out.println("True");
        else
            System.out.println("False");
    }
}