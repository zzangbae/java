// and, or 혼합 - 굉장한 숫자
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n % 2 == 1 && n % 3 == 0 || n % 2 == 0 && n % 5 == 0);
    }
}