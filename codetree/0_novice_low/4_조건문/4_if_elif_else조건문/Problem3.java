// if elif else 조건문 - 살 수 있는 물건
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n >= 3000)
            System.out.println("book");
        else if(n >= 1000)
            System.out.println("mask");
        else
            System.out.println("no");
    }
}