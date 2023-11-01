// if if 조건문 - 두번의 연산
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a % 2 == 1)
            a += 3;
        if(a % 3 == 0)
            a /= 3;
        System.out.println(a);
    }
}