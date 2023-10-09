import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 강력한 폭발, t식으로 풀기
 */
public class Problem3me {
    public static final int MAX_N = 20;

    public static int n;
    public static int[][] boomType = new int[MAX_N][MAX_N];
    public static boolean[][] boomed = new boolean[MAX_N][MAX_N];
    public static ArrayList<Pair> bombPos = new ArrayList<>();
    public static int ans;

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    // t: 폭탄 타입, x, y: 폭탄 위치
    public static void boom(int x, int y) {
        Pair[][] boomPairs = new Pair[][]{
            {},
            {new Pair(-2, 0), new Pair(-1, 0), new Pair(0, 0), new Pair(1, 0), new Pair(2, 0)},
            {new Pair(-1, 0), new Pair(0, 1), new Pair(0, 0), new Pair(1, 0), new Pair(0, -1)},
            {new Pair(-1, -1), new Pair(-1, 1), new Pair(0, 0), new Pair(1, 1), new Pair(1, -1)}
        };

        // 폭탄 터치기
        for(int i = 0; i < 5; i++) {
            int nx = x + boomPairs[boomType[x][y]][i].x;
            int ny = y + boomPairs[boomType[x][y]][i].y;

            if(inRange(nx, ny))
                boomed[nx][ny] = true;
        }

    }

    public static int calc() {
        // 1. 초토화 초기화시키기
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                boomed[i][j] = false;

        // 2. 폭탄위치 찾아서 폭탄 값대로 터치기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(boomType[i][j] != 0) {
                    boom(i, j);
                }
            }
        }
        
        // 3. 초토화된 곳 찾기
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(boomed[i][j])
                    cnt++;
            }
        }

        return cnt;
    }

    public static void findMaxArea(int c) {
        // 종료조건
        if(c == bombPos.size()) {
            ans = Math.max(ans, calc());
            return;
        }

        int x = bombPos.get(c).x;
        int y = bombPos.get(c).y;

        for(int i = 1; i <= 3; i++) {
            boomType[x][y] = i;
            findMaxArea(c + 1);
            boomType[x][y] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                int bombPlace = sc.nextInt();
                if(bombPlace == 1)
                    bombPos.add(new Pair(i, j));
            }
        
        findMaxArea(0);
        System.out.println(ans);
    }
}
