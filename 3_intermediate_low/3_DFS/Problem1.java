import java.util.*;

/**
 * 그래프 탐색 : 1번 정점에서 시작하여 주어진 간선을 따라 이동했을 때, 도달할 수 있는 다른 정점의 수를 구하기
 */
public class Problem1 {

    public static int n;
    public static int m;
    public static int[][] adj;
    public static int cnt;  // 도달할 수 있는 정점의 갯수
    public static int[] visited;   // visit 함수
    
    // DFS
    public static void DFS(int v) {
        for(int i = 1; i <= n; i++) {
            // 인접해있고, 들렸던 곳이 아니라면 dfs
            if(adj[v][i] == 1 && visited[i] != 1) {
                visited[i] = 1;
                cnt++;
                DFS(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        adj = new int[n + 1][n + 1];
        visited = new int[n + 1];

        // 인접 행렬
        // 공간 복잡도 : O(N^2)
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
        visited[1] = 1;
        DFS(1);
        System.out.println(cnt);
    }    
}
