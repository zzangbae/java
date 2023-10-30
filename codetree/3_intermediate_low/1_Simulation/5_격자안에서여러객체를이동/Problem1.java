import java.util.*;

/**
 * 숫자가 가장 큰 인접한 곳으로 동시에 이동
 * 19분 소요 - ++ 6분소요
 */
public class Problem1 {
    
    public static final int MAX_N = 20;
    public static final int DIR_NUM = 4;
    public static final int[] dx = new int[]{-1, 1, 0, 0};  // 상하좌우
    public static final int[] dy = new int[]{0, 0, -1, 1};  // 상하좌우

    public static int n, m, t;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] count = new int[MAX_N][MAX_N];
    public static int[][] nextCount = new int[MAX_N][MAX_N];
    
    // x, y가 범위안에 있는지 확인
    public static boolean inRange(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;
        return true;
    }

    // (x, y)점의 근처에서 가장 큰 점으로 이동
    public static void move(int x, int y) {
        int deterX = -1;
        int deterY = -1;
        int maxNum = 0;  
        for(int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!inRange(nx, ny)) continue;
            // 상하좌우 순이고, 초과일때만 방향이 변경된다.
            if(grid[nx][ny] > maxNum) {
                maxNum = grid[nx][ny];
                deterX = nx;
                deterY = ny;
            }
        }
        // 이동방향을 설정하였으니 거기로 구슬을 이동시킨다.
        nextCount[deterX][deterY] += 1;
    }

    public static void removeOver2AndCopy() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                if(nextCount[i][j] > 1)
                    nextCount[i][j] = 0;
                count[i][j] = nextCount[i][j];
            }
    }

    public static void initializeNextC() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                nextCount[i][j] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // 격자
        m = sc.nextInt();   // 구슬의 갯수
        t = sc.nextInt();   // t초 후
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for(int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            count[r - 1][c - 1] = 1;
        }

        while(t-- > 0) {
            // nextCount 초기화 필요 
            // count를 순회하면서 구슬 위치 찾기, 그리고 이동시키기
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(count[i][j] == 1) {
                        move(i, j);
                    }
                }
            }
            // 두개이상 구슬 삭제하고 복사
            removeOver2AndCopy();
            // nextCount 초기화시키기
            initializeNextC();
        }
        // 갯수세기
        int result = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                result += count[i][j];
        
        System.out.println(result);
    }
}
