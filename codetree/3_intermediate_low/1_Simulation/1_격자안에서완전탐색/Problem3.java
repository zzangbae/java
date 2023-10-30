import java.util.*;

/**
 * 트로미노
 * 14:48~15:19(31분)
 */
public class Problem3 {
    public static final int MAX_N = 200;
    public static final int MAX_M = 200;

    public static int n, m;
    public static int[][] grid = new int[MAX_N + 1][MAX_M + 1];
    
    // 특정 점 3개가 함수에 입력값으로 주어지면, 모두 범위 안에 있는 지 확인
    public static boolean inRange(int x1, int y1, int x2, int y2, int x3, int y3) {
        if(x1 < 0 || x1 >= n || y1 < 0 || y2 >= m)
            return false;
        if(x2 < 0 || x2 >= n || y2 < 0 || y2 >= m)
            return false;
        if(x3 < 0 || x3 >= n || y3 < 0 || y3 >= m)
            return false;
        return true;
    }


    // 특정 점이 들어왔을 때 해당 점으로 만들 수 있는 트로미노들의 최대값 구하기
    public static int func(int x, int y) {
        int result = 0;
        // 일자 - 세로
        if(inRange(x, y, x - 1, y, x + 1, y)) {
            int tmp = grid[x][y] + grid[x - 1][y] + grid[x + 1][y];
            result = Math.max(result, tmp);
        }
        // 일자 - 가로
        if(inRange(x, y, x, y - 1, x, y + 1)) {
            int tmp = grid[x][y] + grid[x][y - 1] + grid[x][y + 1];
            result = Math.max(result, tmp);
        }
        // ㄴ 모양
        if(inRange(x, y, x - 1, y, x, y + 1)) {
            int tmp = grid[x][y] + grid[x - 1][y] + grid[x][y + 1];
            result = Math.max(result, tmp);
        }
        // 반대 ㄴ 모양
        if(inRange(x, y, x - 1, y, x, y - 1)) {
            int tmp = grid[x][y] + grid[x - 1][y] + grid[x][y - 1];
            result = Math.max(result, tmp);
        }
        // ㄱ 모양
        if(inRange(x, y, x, y - 1, x + 1, y)) {
            int tmp = grid[x][y] + grid[x][y - 1] + grid[x + 1][y];
            result = Math.max(result, tmp);
        }
        // 반대 ㄱ 모양
        if(inRange(x, y, x + 1, y, x, y + 1)) {
            int tmp = grid[x][y] + grid[x + 1][y] + grid[x][y + 1];
            result = Math.max(result, tmp);
        }

        return result;
    }
    
    public static void main(String[] args) {
        // 입력값 받기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        // 모든 점을 순회하면서 해당 점의 트로미노 들중에 최대값을 찾고
        // 최대값을 갱신시킨다
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result = Math.max(result, func(i, j));
            }
        }

        // 출력
        System.out.println(result);
    }
}
