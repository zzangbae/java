// 중첩 조건문 - 코로나 메뉴얼
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c1 = sc.next().charAt(0);
        int t1 = sc.nextInt();
        char c2 = sc.next().charAt(0);
        int t2 = sc.nextInt();
        char c3 = sc.next().charAt(0);
        int t3 = sc.nextInt();
        
        int Acnt = 0;
        if(c1 == 'Y')
            if(t1 >= 37)
                Acnt++;
        if(c2 == 'Y')
            if(t2 >= 37)
                Acnt++;
        if(c3 == 'Y')
            if(t3 >= 37)
                Acnt++;
        if(Acnt >= 2)
            System.out.println('E');
        else
            System.out.println('N');

        // 아래와 같이 할 수도 있다.
        if(c1 == 'Y' && t1 >= 37) {
            if(c2 == 'Y' && t2 >= 37 || c3 == 'Y' && t3 >= 37)
                System.out.println('E');
            else
                System.out.println('N');
        }
        else {
            if(c2 == 'Y' && t2 >= 37 && c3 == 'Y' && t3 >= 37)
                System.out.println('E');
            else
                System.out.println('N');
        }
    }
}