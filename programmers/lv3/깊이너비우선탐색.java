import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static final int MAX_N = 200;
    
    public static Queue<Integer> q = new LinkedList<>();
    public static boolean[] visited;
    public static int[][] grid = new int[MAX_N][MAX_N];
    
    
    public static void BFS(int n) {
        while(!q.isEmpty()) {
            int curr = q.poll();
            // 다음점
            for(int i = 0; i < n; i++) {
                if(i == curr)
                    continue;
                // 1 - 연결되어 있고, 들리지 않았다면
                if(grid[curr][i] == 1 && !visited[i]) {
                    int next = i;
                    q.add(next);
                    visited[next] = true;
                }
            }
        }    
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];   // 0-index
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = computers[i][j];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                q.add(i);
                visited[i] = true;
                answer++;
                BFS(n);   
            }
        }
        
        return answer;
    }
}