import java.util.*;

/**
 * 기울어진 직사각형 더 잘 풀기
 */
public class Problem5t {
    public static final int MAX_N = 20;
    public static final int DIR_NUM = 4;

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    
    public static int getScore(int x, int y, int k, int l) {
        int[] dx = new int[]{-1, -1, 1, 1};
        int[] dy = new int[]{1, -1, -1, 1};
        int[] moveNum = new int[]{k, l, k, l};

        int sumOfNums = 0;

        // 기울어진 직사각형의 경계를 쭉 따라가기 ** 이 부분 스킬 기억하자
        for(int d = 0; d < DIR_NUM; d++)
            for(int q = 0; q < moveNum[d]; q++) {
                x += dx[d]; y += dy[d];

                if(!inRange(x, y))
                    return 0;

                sumOfNums += grid[x][y];
            }
        
        return sumOfNums;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int ans = 0;
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                for(int k = 1; k < n; k++)
                    for(int l = 1; l < n; l++)
                        ans = Math.max(ans, getScore(i, j, k, l));
        
        System.out.println(ans);
    }
}
