// 별 n개 출력하기
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while(i <= n) {
            System.out.println('*');
            i++;
        }
    }
}