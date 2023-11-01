// if elif elif else조건문 - 출석 부르기
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a == 1)
            System.out.println("John");
        else if(a == 2)
            System.out.println("Tom");
        else if(a == 3)
            System.out.println("Paul");
        else
            System.out.println("Vacancy");
    }
}