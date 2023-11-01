// and 기호 - 범위 안의 수
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a >= 10 && a <= 20)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}