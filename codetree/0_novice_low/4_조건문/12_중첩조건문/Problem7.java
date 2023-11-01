// 중첩 조건문 - 중앙값 구하기
import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // 중앙값구하기 : 오름차순 했을 때 중앙에 있는 값
        if(a >= b) {
            if(b >= c)
                System.out.println(b);
            else if(a >= c)
                System.out.println(c);
            else
                System.out.println(a);
        }
        // b가 a보다 큰 경우
        else {
            if(c >= b)
                System.out.println(b);
            else if(c >= a)
                System.out.println(c);
            else
                System.out.println(a);
        }
    }
}