// 중첩 조건문 - 최댓값 구하기
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a >= b) {
            if(a >= c) {
                System.out.println(a);
            } else {
                System.out.println(c);
            }
        }
        else if(b >= a) {
            if(b >= c) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }
        }
        else {
            System.out.println(c);
        }

        // 아래와 같이 표현할 수도 있다.
        if(a >= b) {
            if(a >= c)
                System.out.println(a);
            else
                System.out.println(c);
        }
        else {
            if(b >= c)
                System.out.println(b);
            else
                System.out.println(c);
        }
    }
}