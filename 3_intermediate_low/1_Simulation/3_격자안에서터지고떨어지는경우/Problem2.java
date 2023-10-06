import java.util.*;

/*
 * 십자 모양 폭발
 * 11:20~13:13(2시간...한시간 오바)
 */
public class Problem2 {
    public static final int MAX_N = 200;

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] tmp = new int[MAX_N][MAX_N];
    public static int bs;   // 폭발크기 boom size

    public static void gravity(int r, int c) {
        // 1. 열을 순회하며 0의 갯수를 센다.
        // 2. tmp에 0의 갯수 만큼 grid위층에서 뽑아오기
        for(int j = 0; j < n; j++) {
            int cnt = 0;    // 0의 갯수
            for(int i = 0; i < n; i++) {
                if(grid[i][j] == 0)
                    cnt++;
            }
            // 폭발에 영향이 없는 열은 그대로 복사
            if(cnt == 0) {
                for(int i = 0; i < n; i++) {
                    tmp[i][j] = grid[i][j];
                }
                continue;
            }
            if(j == c) {
                int xx = 0;
                for(int i = n - 1; i >= 0; i--) {
                    if(grid[i][j] != 0)
                        tmp[i][j] = grid[i][j];
                    else {
                        // 0을 만남
                        xx = i;
                        break;
                    }
                }
                for(int i = xx - 1; i >= 0; i--) {
                    if(grid[i][j] != 0) {
                        tmp[xx][j] = grid[i][j];
                        xx--;
                    }
                }

            } else {
                // 폭발에 영향이 있는 열에서 폭발 영향 밑에 있는 행들
                for(int i = n - 1; i >= r + cnt; i--) {
                    tmp[i][j] = grid[i][j];
                }
                // 폭발에 영향이 있는 열에서 폭발 영향 위에 있는 행들
                for(int i = r; i >= cnt; i--) {
                    tmp[i][j] = grid[i - cnt][j];
                }
            }
        }

        // tmp를 grid에 복사
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = tmp[i][j];
    }

    // 폭발
    public static void boom(int r, int c) {
        // 먼저 터치기 -> 0으로 grid 구멍 뚫기
        for(int j = c - bs + 1; j <= c + bs - 1; j++) {
            if(j == c)
                continue;
            if(j < 0 || j >= n)
                continue;
            grid[r][j] = 0;
        }
        for(int i = r - bs + 1; i <= r + bs - 1; i++) {
            if(i < 0 || i >= n)
                continue;
            grid[i][c] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();    

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        bs = grid[r][c];

        boom(r, c);
        gravity(r, c);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }    
}
