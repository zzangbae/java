import java.util.*;

/**
 * 1차원 바람
 * 19:18~20:04(46분)
 */
public class Problem3 {
    public static final int MAX_N = 100;
    public static final int MAX_M = 100;

    public static int n, m, q;
    public static int[][] grid = new int[MAX_N + 1][MAX_M + 1];

    // r이 주어졌을 때의 이동, 왼쪽으로 이동시킨다.
    public static void lShift(int r) {
        int tmp = grid[r][1];
        for(int i = 1; i <= m - 1; i++) {
            grid[r][i] = grid[r][i + 1];
        }
        grid[r][m] = tmp;
    }

    // l이 주어졌을 때의 이동, 오른쪽으로 이동시킨다.
    public static void rShift(int r) {
        int tmp = grid[r][m];
        for(int i = m; i > 1; i--) {
            grid[r][i] = grid[r][i - 1];
        }
        grid[r][1] = tmp;
    }

    // 두 행을 비교해서 같은 열에 같은 값이 있는지 체크
    public static boolean check(int a, int b) {
        for(int i = 1; i <= m; i++) {
            if(grid[a][i] == grid[b][i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                grid[i][j] = sc.nextInt();
        
        while(q-- > 0) {
            int r = sc.nextInt();   // 바람이 부는 행, 넣을 때 r - 1로 넣기
            char c = sc.next().charAt(0);   // 방향
            char prevOc = c;    // 이전의 전파 방향(위로 갈때)
            char prevUc = c;    // 이전의 전파 방향(아래로 갈때)

            // 현재 행 이동
            // L -> rShift / R -> lShift
            if(c == 'L')
                rShift(r);
            else
                lShift(r);

            // 위로 전파 여부판단하며 행이동
            for(int i = r - 1; i >= 1; i--) {
                // 이전 전파 행과 비교(동일 열의 값이 있는지)
                if(check(i + 1, i)) {
                    // 이전에 왼쪽에서 부는 바람이였다면, 이제 오른쪽에서 부는 바람 -> lShift가 되어야함
                    if(prevOc == 'L') {
                        lShift(i);
                        prevOc = 'R';
                    } else {
                        rShift(i);
                        prevOc = 'L';
                    }
                } else
                    break;  // 전파가 더이상 안됨
            }
            // 아래로 전파 여부 판단하며 행이동
            for(int i = r + 1; i <= n; i++) {
                // 이전 전파 행과 비교(동일 열의 값이 있는지)
                if(check(i - 1, i)) {
                    if(prevUc == 'L') {
                        lShift(i);
                        prevUc = 'R';
                    } else {
                        rShift(i);
                        prevUc = 'L';
                    }
                } else
                    break;  // 전파가 더이상 안됨
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
