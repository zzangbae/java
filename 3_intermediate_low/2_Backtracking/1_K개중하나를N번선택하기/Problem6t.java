import java.util.*;

/**
 * 2명의 도둑 t식으로 풀기
 */
public class Problem6t {
    public static final int MAX_M = 5;
    public static final int MAX_N = 10;

    public static int n, m, c;
    public static int[][] weight = new int[MAX_N][MAX_N];

    public static int[] a = new int[MAX_M];

    public static int ans;
    public static int maxVal;

    // idx: 무게 배열의 인덱스, weight: 가지고 가는 무게의 총합, val: 가치
    public static void findMaxSum(int currIdx, int currWeight, int currVal) {
        if(currIdx == m) {
            if(currWeight <= c)
                maxVal = Math.max(maxVal, currVal);
            return;
        }

        findMaxSum(currIdx + 1, currWeight, currVal);
        findMaxSum(currIdx + 1, currWeight + a[currIdx], currVal + a[currIdx] * a[currIdx]);
    }


    public static int findMax(int sx, int sy) {
        for(int i = sy; i <= sy + m - 1; i++)
            a[i - sy] = weight[sx][i];

        maxVal = 0;
        findMaxSum(0, 0, 0);
        return maxVal;
    }


    public static boolean intersect(int a, int b, int c, int d) {
        // 겹치지 않을 경우를 반전시키기
        return !(b < c || d < a);
    }

    // 두 도둑의 위치가 올바른지 판단
    public static boolean possible(int sx1, int sy1, int sx2, int sy2) {
        // 두 도둑의 훔치려는 물건의 범위가 격자를 벗어나는 경우
        if(sy1 + m - 1 >= n || sy2 + m - 1 >= n)
            return false;
        
        // 두 도둑 위치의 행이 다르다면 겹칠 수 없으므로 가능
        if(sx1 != sx2)
            return true;
        
        // 두 구간이 겹친다면 불가능
        if(intersect(sy1, sy1 + m - 1, sy2, sy2 + m - 1))
            return false;

        // 행이 같으면서 구간끼리 겹치지 않으면
        // 가능
        return true;
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
                        // 두 도둑의 위치가 올바른지 판단
                        // 각 위치에서 얻을 수 있는 최대 가치의 합을 ans와 비교하여 갱신
                        if(possible(sx1, sy1, sx2, sy2))
                            ans = Math.max(ans, findMax(sx1, sy1) + findMax(sx2, sy2));
                    }
        
        System.out.print(ans);
    }
}
