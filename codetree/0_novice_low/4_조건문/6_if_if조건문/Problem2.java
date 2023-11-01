// if if조건문 - 숫자의 조건여부2
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a == 5)
            System.out.println('A');
        if(a %2 == 0)
            System.out.println('B');
    }
}