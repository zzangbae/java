import java.util.*;

/**
 * 그리드 상에서의 DFS 탐색
 * 두 방향 탈출 가능 여부 판별하기
 * 경로가 있는지 여부를 판단
 */
public class Problem2 {
    public static final int MAX_N = 100;
    public static final int MAX_M = 100;
    public static final int[] dx = new int[]{1, 0}; // 아래 오른쪽
    public static final int[] dy = new int[]{0, 1}; // 아래 오른쪽

    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_M];
    public static boolean[][] visited = new boolean[MAX_N][MAX_M];  // 들린 곳

    public static boolean isOkay = false;   // 끝점도착 가능여부

    // 범위 안에 있는지 판단
    public static boolean inRange(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m)
            return false;
        return true;
    }

    // 다음 점으로 갈 수 있는지 판단
    public static boolean canGo(int x, int y) {
        // 1. 범위 확인
        if(!inRange(x, y))
            return false;
        // 2. 들림 확인, 3. 뱀 없는지 확인 -> 들렸거나, 뱀있느면 못감
        if(visited[x][y] == true || grid[x][y] == 0)
            return false;
        return true;    // 그외에는 갈 수 있음
    }

    public static void DFS(int x, int y) {
        for(int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(canGo(nx, ny)) {
                // 끝점인 경우
                if(nx == n - 1 && ny == m - 1) {
                    isOkay = true;
                    return;
                }
                else {  // 끝점 아닌 경우, 더 탐색
                    visited[nx][ny] = true;
                    DFS(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        // 시작점 들리기
        visited[0][0] = true;
        DFS(0, 0);
        if(isOkay)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
