// 정수 입력받아 배수 출력
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n; i <= n * 5; i += n)
            System.out.print(i + " ");
    }
}