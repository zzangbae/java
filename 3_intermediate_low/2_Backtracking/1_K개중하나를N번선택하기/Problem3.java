import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/**
 * 강력한 폭발
 * 18:09~18:59(50분)
 */
public class Problem3 {
    public static final int MAX_N = 20;

    public static int n;
    public static int boomCount;
    public static ArrayList<Pair> booms = new ArrayList<>();
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int ans = 0;

    // 터진 위치 세기
    public static int areaCount(int[][] grid) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    count++;
            }
        }    
        return count;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    // t는 몇번째 터짐 모양인지
    // bCnt번째 폭탄이 터지는 것을 복사된 grid에 넣어서 제시
    public static int[][] shape(int t, int bCnt) {
        int[] dx = new int[]{-2, -1, 1, 2, -1, 0, 1, 0, -1, 1, 1, -1};
        int[] dy = new int[]{0, 0, 0, 0, 0, 1, 0, -1, 1, 1, -1, -1};
        int DIR_NUM = 4;

        Pair hack = booms.get(bCnt);
        int x = hack.x;
        int y = hack.y;
        for(int i = t * DIR_NUM; i < (t + 1) * DIR_NUM; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny)) {
                grid[nx][ny] = 1;   // 터짐 처리
            }
        }
        return grid;
    }

    // bCnt번째 폭탄이 터졌을 때, 영향
    public static void boom(int bCnt) {
        // 종료조건
        if(bCnt == booms.size()) {
            // 터진 영역 세기
            int boomArea = areaCount(grid);
            ans = Math.max(boomArea, ans);
            return;
        }
        
        // 재귀 호출
        for(int i = 0; i < 3; i++) {
            int[][] tmp = new int[MAX_N][MAX_N];
            for(int x = 0; x < n; x++) {
                for(int y = 0; y < n; y++) {
                    tmp[x][y] = grid[x][y];
                }
            }
            shape(i, bCnt); // grid에 영향을 끼치고
            boom(bCnt + 1);
            // 이전의 값으로 다시 복구 -> 백트래킹
            for(int x = 0; x < n; x++) {
                for(int y = 0; y < n; y++) {
                    grid[x][y] = tmp[x][y];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) {
                    booms.add(new Pair(i, j));
                }
            }
        }
        
        boom(0);

        System.out.println(ans);
    }
}
