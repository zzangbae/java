// 중첩 조건문 - 남녀노소 구분짓기
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sex = sc.nextInt();
        int age = sc.nextInt();
        if(sex == 0) {
            if(age >= 19)
                System.out.println("MAN");
            else
                System.out.println("BOY");
        }
        else {
            if(age >= 19)
                System.out.println("WOMAN");
            else
                System.out.println("GIRL");
        }
    }
}