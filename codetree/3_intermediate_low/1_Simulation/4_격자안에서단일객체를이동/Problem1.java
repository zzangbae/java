import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 숫자가 더 큰 인접한 곳으로 이동
 */
public class Problem1 {
    public static final int MAX_N = 100;
    public static final int DIR_NUM = 4;
    public static final int[] dx = new int[]{-1, 1, 0, 0};  // 상하좌우
    public static final int[] dy = new int[]{0, 0, -1, 1};
    // visited배열은 필요 없다 -> 여차피 더 큰 곳으로만 계속 이동하기 때문에

    public static int n;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];

    public static boolean inRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }

    public static void main(String[] args) {
        // 1. 현재 위치보다 더 큰 위치로 이동
        // 2. 여러곳인 경우, 상하좌우 방향 순서대로
        // 3. 더이상 움직일 수 없을 때까지 반복
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        Pair curr = new Pair(r, c); // 현재 점

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                grid[i][j] = sc.nextInt();
        
        while(true) {
            int x = curr.x;
            int y = curr.y;
            System.out.print(grid[x][y] + " ");

            boolean isChanged = false;  // 다음점을 찾으면 true로 바뀐다.
            // 다음 점을 찾기
            for(int i = 0; i < DIR_NUM; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 다음 점이 범위 안에 있고, 원래의 값보다 크기가 크다면
                if(inRange(nx, ny) && grid[nx][ny] > grid[x][y]) {
                    curr = new Pair(nx, ny);    // 다음 점을 curr에 담는다
                    isChanged = true;
                    break;
                }
            }
            // 더 이상 움직이지 못한다면 나오기
            if(!isChanged)
                break;
        }
    }
}
