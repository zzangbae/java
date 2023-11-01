// 중첩 조건문 - 일 수 구하기
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 윤년이 아닌 해의 n월에는 몇 일이 있는지 판단
        if(n == 2)
            System.out.println(28);
        else if(n == 4 || n == 6 || n == 9 || n == 11)
            System.out.println(30);
        else
            System.out.println(31);
    }
}