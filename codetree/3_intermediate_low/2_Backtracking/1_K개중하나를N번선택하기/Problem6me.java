import java.util.*;

/**
 * 2명의 도둑, 해설대로 직접 풀기
 */
public class Problem6me {
    public static final int MAX_M = 5;
    public static final int MAX_N = 10;

    public static int n, m, c;
    public static int[][] weight = new int[MAX_N][MAX_N];
    public static int[] a = new int[MAX_M];

    public static int maxVal;
    public static int ans;

    public static boolean intersect(int a, int b, int c, int d) {
        // 겹치지 않을 조건의 반대
        return !(b < c || d < a);
    }

    public static boolean possible(int sx1, int sy1, int sx2, int sy2) {
        // 만약 범위를 넘어선다면 X
        if(sy1 + m - 1 >= n || sy2 + m - 1 >= n)
            return false;
        
        // 다른 행이라면 가능 
        if(sx1 != sx2)
            return true;
        
        // 같은 행이라면 겹치게 된다면 불가능
        if(intersect(sy1, sy1 + m - 1, sy2, sy2 + m - 1))
            return false;
        
        // 같은 행이더라도 겹치지 않는다면 가능
        return true;
    }
    
    // 해당 점으로 부터 나온 최댓값을 찾기
    public static int findMax(int sx, int sy) {
        for(int i = sy; i <= sy + m - 1; i++)
            a[i - sy] = weight[sx][i];
        
        maxVal = 0; // maxVal 초기화
        findMaxSum(0, 0, 0);
        return maxVal;
    }

    public static void findMaxSum(int currIdx, int currWeight, int currVal) {
        // 종료조건
        if(currIdx == m) {
            if(currWeight <= c)
                maxVal = Math.max(maxVal, currVal);
            return;
        }

        // 재귀호출
        // 현재 idx의 무게를 넣지 않고 진행
        findMaxSum(currIdx + 1, currWeight, currVal);
        // 현재 무게를 넣고 진행
        findMaxSum(currIdx + 1, currWeight + a[currIdx], currVal + a[currIdx] * a[currIdx]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                weight[i][j] = sc.nextInt();

        for(int sx1 = 0; sx1 < n; sx1++)
            for(int sy1 = 0; sy1 < n; sy1++)
                for(int sx2 = 0; sx2 < n; sx2++)
                    for(int sy2 = 0; sy2 < n; sy2++) {
                        // 가능하다면 값을 찾아서 갱신시키기
                        if(possible(sx1, sy1, sx2, sy2)) {
                            ans = Math.max(ans, findMax(sx1, sy1) + findMax(sx2, sy2));
                        }
                    }
            
        System.out.println(ans);
    }
}
