import java.util.*;

/**
 * 컨테이너 벨트
 */
public class Problem1 {
    public static final int MAX_N = 200;

    public static int n, t;
    public static int[][] grid = new int[2][MAX_N]; 
    
    public static void move() {
        // 첫 째줄의 마지막
        int temp1 = grid[0][n - 1];
        // 둘 째줄의 첫번째
        int temp2 = grid[1][0];

        // 첫 째줄 shift
        for(int i = n - 1; i > 0; i--) {
            grid[0][i] = grid[0][i - 1]; 
        }
        grid[0][0] = temp2;

        // 둘 째줄 shift
        for(int i = 0; i < n - 1; i++) {
            grid[1][i] = grid[1][i + 1];
        }
        grid[1][n - 1] = temp1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();

        for(int i = 0; i < n; i++)
            grid[0][i] = sc.nextInt();
    
        for(int i = n - 1; i >= 0; i--)
            grid[1][i] = sc.nextInt();

        while(t-- > 0) {
            move();
        }
        
        // 출력
        for(int i = 0; i < n; i++)
            System.out.print(grid[0][i] + " ");
        
        System.out.println();

        for(int i = n - 1; i >= 0; i--)
            System.out.print(grid[1][i] + " ");
    }
}
