import java.util.*;

public class LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        findLCM(n, m);
    }

    // 최소공배수를 구해서 출력하는 함수
    public static void findLCM(int n, int m) {
        // 먼저 최대공약수를 구한다(GCD)
        int gcd = 0;
        for(int i = 1; i <= Math.min(n, m); i++)
            if(n % i == 0 && m % i == 0)
                gcd = i;
        // n * m에서 gcd를 나누면 lcm이 된다.
        int lcm = n * m / gcd;
        System.out.println(lcm);
    }
}
