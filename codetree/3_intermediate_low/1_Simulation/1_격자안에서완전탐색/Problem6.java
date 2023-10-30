import java.util.*;

/**
 * 겹쳐지지 않는 두 직사각형
 * 1:16~1:34(18분)
 */
public class Problem6 {
    public static final int MAX_NUM = 5;

    public static int n, m; // 2~5완전탐색 가능
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];

    public static boolean isDuplicated(int r1, int c1, int r2, int c2, int r3, int c3, int r4, int c4) {
        int[][] count = new int[MAX_NUM][MAX_NUM];
        for(int i = r1; i <= r2; i++)
            for(int j = c1; j <= c2; j++)
                count[i][j]++;
        
        for(int i = r3; i <= r4; i++)
            for(int j = c3; j <= c4; j++)
                count[i][j]++;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(count[i][j] >= 2)
                    return true;
            }
        }
        return false;
    }

    public static int getArea(int x1, int y1, int x2, int y2) {
        int point = 0;
        for(int i = x1; i <= x2; i++)
            for(int j = y1; j <= y2; j++)
                point += grid[i][j];

        return point;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        // 겹쳐지지 않는 두 직사각형을 잡았을 때 얻을 수 있는 최대 합 구하기
        // 직사각형 -> 왼쪽위, 오른쪽 아래
        // 꼭 2개의 직사각형
        int maxPoint = Integer.MIN_VALUE;  // 최소값 INT_MIN구하는 방법 찾기
        for(int r1 = 0; r1 < n; r1++) {
            for(int c1 = 0; c1 < m; c1++) {
                // (r1, c1)가 왼쪽 위의 점
                for(int r2 = r1; r2 < n; r2++) {
                    for(int c2 = c1; c2 < m; c2++) {
                        // (r2, c2)가 오른쪽 아래의 점
                        for(int r3 = 0; r3 < n; r3++) {
                            for(int c3 = 0; c3 < m; c3++) {
                                for(int r4 = r3; r4 < n; r4++) {
                                    for(int c4 = c3; c4 < m; c4++) {
                                        // 두 직사각형이 겹친다면 스킵
                                        if(isDuplicated(r1, c1, r2, c2, r3, c3, r4, c4))
                                            continue;
                                        // 그렇지 않다면 넓이 계산해서 더하기
                                        int area1 = getArea(r1, c1, r2, c2);
                                        int area2 = getArea(r3, c3, r4, c4);
                                        maxPoint = Math.max(maxPoint, area1 + area2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(maxPoint);
    }    
}
