// if elif elif else 조건문 - 알파벳에 따른 평가
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        if(c == 'S')
            System.out.println("Superior");
        else if(c == 'A')
            System.out.println("Excellent");
        else if(c == 'B')
            System.out.println("Good");
        else if(c == 'C')
            System.out.println("Usually");
        else if(c == 'D')
            System.out.println("Effort");
        else
            System.out.println("Failure");
    }
}