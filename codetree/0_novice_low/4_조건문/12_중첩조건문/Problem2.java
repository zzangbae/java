// 중첩 조건문 - 윤년인가
import java.util.Scanner;
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        if(y % 400 == 0)
            System.out.println("true");
        else if(y % 100 == 0)
            System.out.println("false");
        else if(y % 4 == 0)
            System.out.println("true");
        else
            System.out.println("false");

        // 아래와 같이 표현할 수 있다.
        if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            System.out.println("true");
        else
            System.out.println("false");
    }
}