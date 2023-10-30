import java.util.*;

public class AsquareB {
    // a^b를 구하는 함수
    public static int power(int a, int b) {
        int cnt = 1;
        for(int i = 1; i <= b; i++)
            cnt *= a;

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = power(a, b);
        System.out.println(result);
    }    
}
