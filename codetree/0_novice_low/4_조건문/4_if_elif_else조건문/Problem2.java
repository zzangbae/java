// if elif else 조건문 - 시력검사2
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        if(a >= 1.0)
            System.out.println("High");
        else if(a >= 0.5)
            System.out.println("Middle");
        else
            System.out.println("Low");
    }
}