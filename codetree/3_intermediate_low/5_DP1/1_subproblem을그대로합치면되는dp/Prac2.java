import java.util.*;

public class Prac2 {
    public static final int MAX_N = 46;
    public static final int UNUSED = -1;

    public static int n;
    public static int[] memo = new int[MAX_N + 1];
    
    public static int memoRecur(int n) {
        if(memo[n] != UNUSED)
            return memo[n];
        
        if(n <= 2)
            return 1;
        
        return memoRecur(n - 1) + memoRecur(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 메모이제이션 공간 초기화
        for(int i = 0; i < MAX_N + 1; i++)
            memo[i] = UNUSED;
        
        // 메모이제이션을 활용한 재귀
        int result = memoRecur(n);
        System.out.println(result);
    }    
}
