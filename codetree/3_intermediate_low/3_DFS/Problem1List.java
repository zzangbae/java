import java.util.*;

public class Problem1List {
    public static final int MAX_NUM = 1000;
    public static n, m;

    public static ArrayList<Integer>[] graph = new ArrayList[MAX_NUM + 1];
    public static boolean[] visited = new boolean[MAX_NUM + 1];
    public static int cnt = 0;

    public static void DFS(int v) {
        for(int i = 0; i < graph[v].size(); i++) {
            int next = graph[v].get(i);
            if(!visited[next]) {
                visited[next] = true;
                cnt++;
                DFS(next);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        
        while(m-- > 0) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        visited[1] = true;
        DFS(1);

        System.out.println(cnt);
    }
}
