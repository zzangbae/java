import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 갈 수 있는 곳들
 */
public class Problem2 {
    public static final int MAX_N = 100;
    public static final int[] dx = new int[]{-1, 1, 0, 0};
    public static final int[] dy = new int[]{0, 0, -1, 1};
    public static final int DIR_NUM = 4;

    public static int n, k;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            for(int i = 0; i < DIR_NUM; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 안에 있고, 들리지 않았던 곳이며, grid값이 0이면
                if(inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            q.add(new Pair(a - 1, b - 1));
            visited[a - 1][b - 1] = true;
        }

        BFS();

        int result = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                if(visited[i][j])
                    result++;
            }
        
        System.out.println(result);
    }
}
