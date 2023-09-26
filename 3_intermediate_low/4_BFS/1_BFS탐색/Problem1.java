import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 네 방향 탈출 가능 여부 판별하기
 */
public class Problem1 {
    public static final int MAX_NUM = 100;
    public static final int[] dx = new int[]{-1, 1, 0, 0};
    public static final int[] dy = new int[]{0, 0, 1, -1};
    public static final int DIR_NUM = 4;

    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static Queue<Pair> q = new LinkedList<>();
    public static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    public static void BFS() {
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            for(int i = 0; i < DIR_NUM; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 안에 있고, 0이 아니라면, 그리고 들리지 않았던 점이라면
                if(inRange(nx, ny) && grid[nx][ny] != 0 && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        Pair start = new Pair(0, 0);
        q.add(start);
        visited[0][0] = true;
        BFS();
        
        if(visited[n - 1][m - 1])
            System.out.println(1);
        else
            System.out.println(0);
    }
}
