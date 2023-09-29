import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 돌 잘 치우기
 * 16:28~17:43(1시간 15분)
 */
public class Problem4 {
    public static final int MAX_N = 100;
    public static final int MAX_M = 8;  // 돌 방문여부

    public static int n, m, k;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];
    public static int[][] tmpGrid = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[][] tmpVis = new boolean[MAX_N + 1][MAX_N + 1];
    public static Queue<Pair> startList = new LinkedList<>();
    public static Queue<Pair> tmpStartLis = new LinkedList<>();
    public static ArrayList<Pair> stoneList = new ArrayList<>();
    public static int result = 0;

    public static void initializeTmp() {
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                tmpGrid[i][j] = grid[i][j];
    }

    // 조합에서 나온 visited를 바탕으로 tmp 수정하기
    public static void cleanStone(boolean[] vs) {
        for(int i = 0; i < vs.length; i++) {
            if(vs[i]) {
                int x = stoneList.get(i).x;
                int y = stoneList.get(i).y;
                tmpGrid[x][y] = 0;  // 돌치우기
            }
        }
        // System.out.println("----------");
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n; j++) {
        //         System.out.print(tmpGrid[i][j] + " ");
        //     }
        //     System.out.println();
        // }

    }

    public static boolean inRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }

    // BFS돌려서 최댓값 찾기
    public static void BFS() {
        final int DIR_NUM = 4;
        final int[] dx = new int[]{-1, 1, 0, 0};
        final int[] dy = new int[]{0, 0, -1, 1};

        while(!tmpStartLis.isEmpty()) {
            Pair curr = tmpStartLis.poll();
            int x = curr.x;
            int y = curr.y;
            for(int i = 0; i < DIR_NUM; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 1. 범위 안에 있고, 2. 들리지 않았던 점이고, 3. 값이 0이라 갈 수 있는 점이면
                if(inRange(nx, ny) && !tmpVis[nx][ny] && tmpGrid[nx][ny] == 0) {
                    tmpVis[nx][ny] = true;
                    tmpStartLis.add(new Pair(nx, ny));
                }
            }
        }
        // System.out.println("----------");
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n; j++) {
        //         if(tmpVis[i][j])
        //             System.out.print(1 + " ");
        //         else
        //             System.out.print(0 + " ");
        //     }
        //     System.out.println();
        // }

        // result 값 갱신
        int tmpRes = 0;
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++) {
                if(tmpVis[i][j])
                    tmpRes++;
            }
        result = Math.max(result, tmpRes);
    }

    public static void initializeVis() {
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                tmpVis[i][j] = visited[i][j];
    }

    public static <T> Queue<T> deepCopyQueue(Queue<T> oQ) {
        List<T> list = new ArrayList<>(oQ);
        Queue<T> cQ = new LinkedList<>(list);
        return cQ;
    }

    public static void initializeSL() {
        tmpStartLis = deepCopyQueue(startList);
    }

    // w개 중, r개를 선택
    public static void combination(boolean[] vs, int start, int w, int r) {
        // 조합이 선택 완료되면
        if(r == 0) {
            // 1. tmpGrid 초기화
            initializeTmp();
            // 2. 선택된 돌을 제외한 tmp만들기(돌 치우기)
            cleanStone(vs);
            // 3. tmpVis 초기화
            initializeVis();
            // 4. tmpStartList또한 초기화
            initializeSL();
            // 5. 만들어진 tmp를 기준으로 BFS를 통해서 result를 최댓갓으로 갱신
            BFS();
        }
        for(int i = start; i < w; i++) {
            vs[i] = true;
            combination(vs, i + 1, w, r - 1);
            vs[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) {
                    stoneList.add(new Pair(i, j));
                }
            }
        }

        for(int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            visited[r][c] = true;
            startList.add(new Pair(r, c));
        }
        boolean[] vs = new boolean[MAX_M];
        combination(vs, 0, stoneList.size(), m);
        // 돌 선택 -> tmp로 선택된 돌을 지운 배열 만들기 -> 시작점으로부터 갯수 구하기
        System.out.println(result);
    }
}
