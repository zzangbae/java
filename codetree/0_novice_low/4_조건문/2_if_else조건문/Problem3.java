import java.util.Scanner;

// if else 조건문 - 비교에 따른 연산
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a > b)
            System.out.println(a * b);
        else
            System.out.println(b / a);
    }
}