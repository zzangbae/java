import java.util.Scanner;

public class Problem6re {
    public static final int MAX_N = 100000;

    public static int n, m;
    public static int[] uf = new int[MAX_N + 1];

    // 주어진 간선 중, 활용가능한 간선
    public static int maxCnt = 0;

    public static int find(int x) {
        if(uf[x] == x)
            return x;
        return uf[x] = find(uf[x]);
    }

    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++)
            uf[i] = i;
    
        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(find(x) != find(y)) {
                maxCnt++;
                union(x, y);
            }
        }

        // 트리는 n - 1개의 간선을 가짐. 싸이클X
        System.out.println(n - 1 - maxCnt + m - maxCnt);
    }    
}
