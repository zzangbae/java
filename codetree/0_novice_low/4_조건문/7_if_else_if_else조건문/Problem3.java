// if else if else조건문 - 3 또는 5의 배수
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a % 3 == 0)
            System.out.println("YES");
        else
            System.out.println("NO");
        if(a % 5 == 0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}