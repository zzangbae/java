import java.util.*;

public class Problem5_re2 {
    public static final int UNUSED = -1;
    public static final int MAX_NUM = 19;

    public static int[] memo = new int[MAX_NUM + 1];

    public static void initializeMemo() {
        for(int i = 0; i < MAX_NUM + 1; i++) {
            memo[i] = -1;
        }
    }

    public static int numOfUniqueBst(int n) {
        // 이 부분이 메모이제이션
        if(memo[n] != UNUSED)
            return memo[n];
        
        // 이 부분이 초기값
        if(n <= 1)
            return 1;
        
        int numberOfUniqueBst = 0;
        // 이 부분이 점화식
        for(int i = 0; i < n; i++)
            numberOfUniqueBst += numOfUniqueBst(i) * numOfUniqueBst(n - i - 1);
        
        return memo[n] = numberOfUniqueBst;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        initializeMemo();
        System.out.println(numOfUniqueBst(n));
    }    
}
