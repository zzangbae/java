import java.util.Scanner;
// 삼항 연산자 - 2개중 최대
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a > b ? a : b);
    }
}