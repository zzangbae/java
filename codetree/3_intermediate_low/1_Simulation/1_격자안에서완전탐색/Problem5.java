import java.util.*;

/**
 * 기울어진 직사각형
 * 12:44~13:11(27분)
 */
public class Problem5 {
    public static final int MAX_N = 20; // 20이하 -> 완탐 될듯?!

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];

    public static boolean inRange(int x, int y, int k, int l) {
        return x - k - l >= 0 && y + k < n && y - l >= 0;
    }

    public static int getPoint(int x, int y, int k, int l) {
        int point = 0;
        // 1번 올라가는 동안
        for(int w = 0; w <= k; w++) {
            point += grid[x - w][y + w];
        }

        for(int v = 1; v <= l; v++) {
            point += grid[x - k - v][y + k - v];
        }

        for(int e = 1; e <= k; e++) {
            point += grid[x - k - l + e][y + k - l - e];
        }

        for(int q = 1; q < l; q++) {
            point += grid[x - l + q][y - l + q];
        }
        return point;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int maxPoint = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // k는 1번 대각선 길이(영사했을 때)
                for(int k = 1; k < n; k++) {
                    // l은 2번 대각선 길이(영사했을 때)
                    for(int l = 1; l < n; l++) {
                        // k, l이 정해지면 사각형이 확정된다.
                        // 범위 안을 만족하는지 판단하고, 만족시키면 값을 모두 더한다.
                        if(inRange(i, j, k, l)) {
                            int tmpPoint = getPoint(i, j, k, l);
                            maxPoint = Math.max(maxPoint, tmpPoint);
                        }
                    }
                }
            }
        }
        System.out.println(maxPoint);
    }
}
