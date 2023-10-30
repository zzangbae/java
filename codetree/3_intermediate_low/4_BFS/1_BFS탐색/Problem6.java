import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 우리는 하나
 * 17:56~18:43(47분)
 */
public class Problem6 {
    public static final int MAX_N = 8;

    public static int n, k, u, d;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int result = 0;   // 최대 들릴 수 있는 나라 수
    public static Queue<Pair> q = new LinkedList<>();

    // visited함수 초기화
    public static void initializeVis() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                visited[i][j] = false;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    // BFS 돌리기
    public static void BFS() {
        final int DIR_NUM = 4;
        final int[] dx = new int[]{-1, 1, 0, 0};
        final int[] dy = new int[]{0, 0, -1, 1};

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            for(int i = 0; i < DIR_NUM; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx, ny) && !visited[nx][ny] && Math.abs(grid[x][y] - grid[nx][ny]) >= u && Math.abs(grid[x][y] - grid[nx][ny]) <= d) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));    
                }
            }
        }

        int tmp = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j])
                    tmp++;
            }
        }

        // System.out.println("------------");
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0 ; j < n; j++) {
        //         if(visited[i][j])
        //             System.out.print(1 + " ");
        //         else
        //             System.out.print(0 + " ");
        //     }
        //     System.out.println();
        // }

        result = Math.max(result, tmp);
    }

    // n * n개의 도시 중, k개의 도시 고르기(2차원 조합)
    public static void combination(int row, int col, int k, List<Pair> selected) {
        // k개의 도시가 선택되었다면
        if(selected.size() == k) {
            // visited는 초기화해야한다.
            initializeVis();
            // 골라진 것들을 Q에 넣고 BFS를 돌리기
            for(Pair p : selected) {
                int x = p.x;
                int y = p.y;
                visited[x][y] = true;
                q.add(p);
            }
            BFS();
        }
        for(int r = row; r < n; r++) {
            for(int c = col; c < n; c++) {
                // 현재 원소를 선택
                selected.add(new Pair(r, c));

                // 다음 원소로 이동
                combination(r, c + 1, k, selected);

                // 백트래킹 : 현재원소를 제거하고 다음 원소로 진행
                selected.remove(selected.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // k개의 도시로부터 갈 수 있는 서로 다른 도시의 갯수 최대
        // 상하좌우 인접한 도시 이동
        // 두 도시간의 높이의 차가 u이상 d이하인 경우에만 이동이 가능
        // k개의 도시를 적절하게 골라 갈 수 있는 서로 다른 도시의 수 최대
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        List<Pair> l = new ArrayList<>();
        combination(0, 0, k, l);

        System.out.println(result);
    }
}
