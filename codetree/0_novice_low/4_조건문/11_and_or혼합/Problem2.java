// and, or 혼합 - 숫자의 계절은(if조건 나열 순서의 중요성)
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        if(m >= 12 || m <= 2)
            System.out.println("Winter");
        else if(m >= 9)
            System.out.println("Fall");
        else if(m >= 6)
            System.out.println("Summer");
        else
            System.out.println("Spring");
    }
}