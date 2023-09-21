import java.util.*;

/**
 * 마을 구분하기
 */
public class Problem3 {
    public static final int MAX_N = 25;
    public static final int[] dx = new int[]{-1, 0, 1, 0};
    public static final int[] dy = new int[]{0, 1, 0, -1};
    public static final int dirNum = 4; // 상수는 대문자와 언더바로 하긔!!!!!****

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int bCnt = 0;  // 마을 갯수
    public static int p = 0;    // 마을애 있는 사람 수
    public static ArrayList<Integer> people = new ArrayList<>();    // 마을 사람 수
    
    public static boolean inRange(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;
        return true;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y))
            return false;
        if(visited[x][y] == true || grid[x][y] == 0)
            return false;
        return true;
    }

    public static void DFS(int x, int y) {
        for(int i = 0; i < dirNum; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(canGo(nx, ny)) {
                visited[nx][ny] = true;
                p++;
                DFS(nx, ny);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // grid 순회
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 들리지 않았던 곳이고, 1이면
                if(visited[i][j] == false && grid[i][j] == 1) {
                    visited[i][j] = true;
                    bCnt++;
                    p = 1;  // 마을 사람 수 시작: 1
                    DFS(i, j);
                    people.add(p);
                }
            }
        }
        Collections.sort(people);
        System.out.println(bCnt);
        for(int pe : people)
            System.out.println(pe);
    }
}
