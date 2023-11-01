// if if조건문 - 최대 2번의 연산
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a % 2 == 0)
            a /= 2;
        if(a % 2 == 1)
            a = (a + 1) / 2;
        System.out.println(a);
    }
}