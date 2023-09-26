import java.util.*;

/**
 * 삼각형 컨베이어 벨트
 */
public class Problem2 {
    public static final int MAX_N = 200;
    public static int n, t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        int[] x = new int[MAX_N];
        int[] y = new int[MAX_N];
        int[] z = new int[MAX_N];

        for(int i = 0; i < n; i++)
            x[i] = sc.nextInt();

        for(int i = 0; i < n; i++)
            y[i] = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            z[i] = sc.nextInt();
        
        while(t-- > 0) {
            int xLast = x[n - 1];
            int yLast = y[n - 1];
            int zLast = z[n - 1];

            for(int i = n - 1; i > 0; i--)
                x[i] = x[i - 1];
            x[0] = zLast;

            for(int i = n - 1; i > 0; i--)
                y[i] = y[i - 1];
            y[0] = xLast;
        
            for(int i = n - 1; i > 0; i--)
                z[i] = z[i - 1];
            z[0] = yLast;
        }

        for(int i = 0; i < n; i++)
            System.out.print(x[i] + " ");
        System.out.println();

        for(int i = 0; i < n; i++)
            System.out.print(y[i] + " ");
        System.out.println();

        for(int i = 0; i < n; i++)
            System.out.print(z[i] + " ");
    }
}
