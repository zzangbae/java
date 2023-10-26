import java.util.Scanner;

/**
 * 트리 -> n-1개의 간선으로 이루어짐. + 싸이클없음
 * 따라서, 사이클이 생기지 않도록 최대한 간선을 선택
 * 간선을 확인하면서, 싸이클이 생기지 않게 이용할 수 있는 간선의 갯수를 센다 -> cnt
 * 주어진 간선의 수가 m일 때, m - cnt만큼의 간선이 제거되어야 한다.
 * 추가되어야 할 간선의 수는 n - 1 - cnt(전체트리의 간선 - 이미 쓸 수 있는 간선)
 * 따라서 전체 필요한 연산의 수는 n - cnt + n - 1 - cnt
 */
public class Problem6t {
    public static final int MAX_N = 100000;

    public static int n, m;
    public static int[] uf = new int[MAX_N + 1];
    // 싸이클 없이 최대로 이용할 수 있는 간선의 수
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

        System.out.println(m - maxCnt + n - 1 - maxCnt);
    }
}
