import java.util.*;

/**
 * 합을 옆으로 밀어 출력
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += sc.nextInt();
        
        String str = Integer.toString(sum);
        String result = str.substring(1) + str.substring(0, 1);

        System.out.println(result);
    }    
}
