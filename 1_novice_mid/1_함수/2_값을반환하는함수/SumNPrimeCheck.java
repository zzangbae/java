import java.util.*;

// 함수를 이용한 합과 소수 판별
public class SumNPrimeCheck {
    
    // 수시인지를 판별하는 함수
    public static boolean isPrime(int n) {
        if(n == 1)
            return false;
        
        for(int i = 2; i < n; i++)
            if(n % i == 0)
                return false;
        return true;
    }

    // 자릿수의 합이 짝수인지 여부를 반환하는 함수
    public static boolean isDigitSumEven(int n) {
        int digitSum = 0;
        while(n > 0) {
            digitSum += n % 10;
            n /= 10;
        }
        if(digitSum % 2 == 0)
            return true;
        return false;
    }

    // 해당숫자가 소수이면서 자릿수의 합이 짝수인지 여부를 반환하는 함수
    public static boolean judgeNum(int n) {
        if(isPrime(n) && isDigitSumEven(n))
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();   // 1~100
        int b = sc.nextInt();   // 1~100

        int cnt = 0;
        for(int i = a; i <= b; i++) {
            if(judgeNum(i))
                cnt++;
        }

        System.out.print(cnt);
    }
}
