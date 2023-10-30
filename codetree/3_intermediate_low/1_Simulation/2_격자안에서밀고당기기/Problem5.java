import java.util.*;
/**
 * 기울어진 직사각형의 회전
 * 11:26~12:26(60분)
 */
public class Problem5 {
    public static final int MAX_N = 100;

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];

    // 시계 방향
    public static void turn(int r, int c, int m1, int m2, int m3, int m4) {
        int[] dx = new int[]{-1, -1, 1, 1};
        int[] dy = new int[]{-1, 1, 1, -1};
        int DIR_NUM = 4;
        int[] d = new int[]{m4, m3, m2, m1};

        int[] tmp = new int[4];
        // 임시값 저장
        int rTmp = r;
        int cTmp = c;
        for(int i = 0; i < DIR_NUM; i++) {
            tmp[i] = grid[rTmp][cTmp];
            // 다음 가장자리로 이동
            rTmp += d[i] * dx[i];
            cTmp += d[i] * dy[i];
        }

        for(int i = 0; i < DIR_NUM; i++) {
            for(int j = d[i]; j > 1; j--) {
                grid[r + j * dx[i]][c + j * dy[i]] = grid[r + (j - 1) * dx[i]][c + (j - 1) * dy[i]];
            }
            // 맨 끝에서 하나 앞선 값은 따로 처리
            grid[r + dx[i]][c + dy[i]] = tmp[i];
            // r, c위치 옮겨주기
            r += d[i] * dx[i];
            c += d[i] * dy[i];
        }
    }

    // 반시계 방향
    public static void reverseTurn(int r, int c, int m1, int m2, int m3, int m4) {
        int[] dx = new int[]{-1, -1, 1, 1};
        int[] dy = new int[]{1, -1, -1, 1};
        int DIR_NUM = 4;
        int[] d = new int[]{m1, m2, m3, m4};

        int[] tmp = new int[4];
        // 임시값 저장
        int rTmp = r;
        int cTmp = c;
        for(int i = 0; i < DIR_NUM; i++) {
            tmp[i] = grid[rTmp][cTmp];
            // 다음 가장자리로 이동
            rTmp += d[i] * dx[i];
            cTmp += d[i] * dy[i];
        }

        for(int i = 0; i < DIR_NUM; i++) {
            for(int j = d[i]; j > 0; j--) {
                grid[r + j * dx[i]][c + j * dy[i]] = grid[r + (j - 1) * dx[i]][c + (j - 1) * dy[i]];
            }
            // 맨 끝값 넣기
            grid[r + dx[i]][c + dy[i]] = tmp[i];
            // r, c위치 옮겨주기
            r += d[i] * dx[i];
            c += d[i] * dy[i];
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
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int dir = sc.nextInt();
        
        // 반 시계 회전
        if(dir == 0) {
            reverseTurn(r, c, m1, m2, m3, m4);
        // 시계 회전
        } else {
            turn(r, c, m1, m2, m3, m4);
        }

        // 회전 후, 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 해설 풀이
 * temp를 통해서 grid의 값을 받아서하면 경계값을 따로 처리할 필요가 없어진다!!
 */