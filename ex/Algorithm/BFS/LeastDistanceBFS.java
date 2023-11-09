import java.util.Queue;
import java.util.LinkedList;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/**
 * 가중치가 동일한 그래프에서의 BFS - 최단거리 찾기(0,0) -> (4, 3)
 */
public class LeastDistanceBFS {
    public static final int X_LEN = 4;
    public static final int Y_LEN = 3;

    public static int[][] step = new int[X_LEN][Y_LEN];
    public static boolean[][] visited = new boolean[X_LEN][Y_LEN];
    public static Queue<Pair> q = new LinkedList<>();

    public static void push(int x, int y, int s) {
        step[x][y] = s;
        visited[x][y] = true;
        q.add(new Pair(x, y));
    }

    public static void BFS() {
        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;

            for(int i = 0; i < 2; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(inRange(newX, newY) && !visited[newX][newY]) {
                    push(newX, newY, step[x][y] + 1);
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < X_LEN && y >= 0 && y < Y_LEN;
    }

    public static void main(String[] args) {
        push(0, 0, 0);  // root vertex를 삽입
        BFS();
        System.out.println(step[X_LEN - 1][Y_LEN - 1]);
    }
}
