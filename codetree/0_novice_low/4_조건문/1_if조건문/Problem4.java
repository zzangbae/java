import java.util.Scanner;

// if조건문 - 정사각형의 넓이
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n * n);
        if(n < 5)
            System.out.println("tiny");
    }
}