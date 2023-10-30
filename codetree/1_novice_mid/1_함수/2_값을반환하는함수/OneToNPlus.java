import java.util.*;

public class OneToNPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int result = sumN(n);
        System.out.println(result);
    }

    public static int sumN(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++)
            sum += i;
        
        return sum / 10;
    }
}