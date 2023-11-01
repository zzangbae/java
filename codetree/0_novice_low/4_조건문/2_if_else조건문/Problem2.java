import java.util.Scanner;

// if else 조건문 - 숫자의 조건 여부
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a >= 113)
            System.out.println(1);
        else
            System.out.println(0);
    }
}