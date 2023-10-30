import java.util.*;

public class GCD {
    // n과 m의 최대공약수를 구해서 출력하는 함수
    public static void findGCD(int n, int m) {
        int gcd = 0;
        for(int i = 1; i <= Math.min(n, m); i++)
            if(n % i == 0 && m % i == 0) 
                gcd = i;
        
        System.out.println(gcd);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        findGCD(n, m);
    }
}
