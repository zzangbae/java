import java.util.*;

public class FindPrime {

    public static boolean IsPrime(int n) {
        // 1은 음수가 아니다.
        if(n == 1)
            return false;
        
        for(int i = 2; i < n; i++)
            if(n % i == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sumOfPrime = 0;
        for(int i = a; i <= b; i++)
            if(IsPrime(i))
                sumOfPrime += i;

        System.out.println(sumOfPrime);
    }    
}
