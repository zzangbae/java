import java.util.Scanner;

// if조건문 - 큰 수에서 빼기
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a >= b)
            System.out.println(a - b);
        if(b > a)
            System.out.println(b - a);
    }
}