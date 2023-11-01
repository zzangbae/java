// and 기호 - 시력검사
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        if(a >= 1.0 && b >= 1.0)
            System.out.println("High");
        else if(a >= 0.5 && b >= 0.5)
            System.out.println("Middle");
        else
            System.out.println("Low");
    }
}