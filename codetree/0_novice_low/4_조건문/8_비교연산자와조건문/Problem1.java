// 비교 연산자와 조건문 - 비교 연산
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a >= b)
            System.out.println(1);
        else
            System.out.println(0);
        if(a > b)
            System.out.println(1);
        else
            System.out.println(0);
        if(b >= a)
            System.out.println(1);
        else
            System.out.println(0);
        if(b > a)
            System.out.println(1);
        else
            System.out.println(0);
        if(a == b)
            System.out.println(1);
        else
            System.out.println(0);
        if(a != b)
            System.out.println(1);
        else
            System.out.println(0);
        
        // 삼항 연산자로 표현하면 훨씬 간단하다.
    }
}