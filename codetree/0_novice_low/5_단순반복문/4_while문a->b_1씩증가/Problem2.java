// n까지 숫자 출력
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while(i <= n) {
            System.out.print(i + " ");
            i++;
        }
    }
}