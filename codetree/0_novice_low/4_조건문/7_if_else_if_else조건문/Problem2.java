// if else if else조건문 - 특정 조건 두 정수 비교
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a < b)
            System.out.print(1 + " ");
        else
            System.out.print(0 + " ");
        if(a == b)
            System.out.println(1);
        else
            System.out.println(0);
    }
}