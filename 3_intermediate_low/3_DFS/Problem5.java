import java.util.*;

public class Problem5 {
    public static final int MAX_N = 100;
    public static final int DIR_NUM = 4;
    public static final int[] dx = new int[]{-1, 0, 1, 0};
    public static final int[] dy = new int[]{0, 1, 0, -1};

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int maxBlockSize = 0;  // 최대 블럭의 크기
    public static int tmpBlockSize;  // 블럭의 크기(임시)
    public static int boomBlock = 0;    // 터지는 블럭의 갯수

    public static boolean inRange(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;
        return true;
    }

    public static boolean canGo(int x, int y, int w) {
        if(!inRange(x, y))
            return false;
        // 들렸거나, 숫자가 다르면 갈 수 없음
        if(visited[x][y] == true || grid[x][y] != w)
            return false;
        return true;
    }

    public static void DFS(int x, int y, int w) {
        for(int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(canGo(nx, ny, w)) {
                visited[nx][ny] = true;
                tmpBlockSize++;
                DFS(nx, ny, w);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // 터지게 되는 블럭의 수, 최대 블럭의 크기를 구하기
        // 블럭 : 같은 숫자로 이루엊있고, 인접해있음
        // 4개 이상인 경우 터지게 된다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmpBlockSize = 1;    // 블럭 크기 초기화 - 1에서 시작해야함
                if(visited[i][j] != true) {
                    int w = grid[i][j];
                    visited[i][j] = true;
                    DFS(i, j, w);
                }
                // 블럭크기가 4이상이라면 터지기
                if(tmpBlockSize >= 4)
                    boomBlock++;
                // 더 큰 블럭의 크기가 등장했다면, 갱신하기
                if(tmpBlockSize > maxBlockSize)
                    maxBlockSize = tmpBlockSize;
            }
        }

        System.out.println(boomBlock + " " + maxBlockSize);
    }
}
