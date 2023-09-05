import java.util.*;

public class FindMagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(IsMagicNumber(n))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    // 짝수이면서, 각 자릿수의 합이 5의 배수인가
    public static boolean IsMagicNumber(int n) {
        return n % 2 == 0 && (n / 10 + n % 5) % 5 == 0;
    }
    // 두 조건이 있는 위와 같은 함수는 하나의 조건을 또 다른 함수로 만들수 있다.
    // -> (n / 10 + n % 5) % 5 == 0 을 다른 함수로 빼서 모듈화하는 것을 의미한다.
}
