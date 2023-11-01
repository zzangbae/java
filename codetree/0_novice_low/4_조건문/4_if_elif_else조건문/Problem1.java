// if elif else 조건문 - 물의 상태
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n >= 100)
            System.out.println("vapor");
        else if(n >= 0)
            System.out.println("water");
        else
            System.out.println("ice");
    }
}