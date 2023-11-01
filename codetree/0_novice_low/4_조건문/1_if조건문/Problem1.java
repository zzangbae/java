import java.util.Scanner;

// if 조건문 - 음수 구별하기
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        if(n < 0)
            System.out.println("minus");
    }
}