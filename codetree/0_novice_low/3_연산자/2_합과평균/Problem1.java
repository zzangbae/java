// 합과 평균 - 합과 평균
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.printf("%d %.1f", a + b, ((double)a + b) / 2);        
    }
}