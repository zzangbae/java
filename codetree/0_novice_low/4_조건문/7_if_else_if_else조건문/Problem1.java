// if else if else조건문 - 두 숫자의 짝홀 여부
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a % 2 == 0)
            System.out.println("even");
        else
            System.out.println("odd");
        if(b % 2 == 0)
            System.out.println("even");
        else
            System.out.println("odd");
    }
}