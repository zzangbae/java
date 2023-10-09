import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 강력한 폭발 t버전
 */
public class Problem3t {
    public static final int BOMB_TYPE_NUM = 3;  // 폭탄 종류
    public static final int MAX_N = 20;

    public static int n;
    public static int[][] bombType = new int[MAX_N][MAX_N];
    public static boolean[][] bombed = new boolean[MAX_N][MAX_N];   // 폭탄이 터진 위치

    public static int ans;

    public static ArrayList<Pair> bombPos = new ArrayList<>();  // 폭탄위치를 담음

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void bomb(int x, int y, int bType) {
        // 폭탄 종류마다 터질 위치를 미리 정의
        Pair[][] bombShapes = {
            {},
            {new Pair(-2, 0), new Pair(-1, 0), new Pair(0, 0), new Pair(1, 0), new Pair(2, 0)},
            {new Pair(-1, 0), new Pair(1, 0), new Pair(0, 0), new Pair(0, -1), new Pair(0, 1)},
            {new Pair(-1, -1), new Pair(-1, 1), new Pair(0, 0), new Pair(1, -1), new Pair(1, 1)}
        };

        // 격자 내 칸에 대해서만 영역을 표시
        for(int i = 0; i < 5; i++) {
            int dx = bombShapes[bType][i].x;
            int dy = bombShapes[bType][i].y;

            int nx = x + dx;
            int ny = y + dy;
            if(inRange(nx, ny))
                bombed[nx][ny] = true;
        }
    }

    public static int calc() {
        // 1. 폭탄이 터진 위치를 표시하는 배열 초기화
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                bombed[i][j] = false;
        
        // 2. 각 폭탄의 타입에 따라 초토화 되는 영역 표시
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(bombType[i][j] > 0)
                    bomb(i, j, bombType[i][j]);
        
        // 3. 초토화된 영역의 수
        int cnt = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(bombed[i][j])
                    cnt++;
        return cnt;
    }

    public static void findMaxArea(int cnt) {
        // 종료조건
        if(cnt == bombPos.size()) {
            ans = Math.max(ans, calc());
            return;
        }
        for(int i = 1; i <= 3; i++) {
            int x = bombPos.get(cnt).x;
            int y = bombPos.get(cnt).y;

            bombType[x][y] = i;
            findMaxArea(cnt + 1);
            bombType[x][y] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                int bombPlace = sc.nextInt();
                if(bombPlace > 0)
                    bombPos.add(new Pair(i, j));
            }
        
        findMaxArea(0);

        System.out.println(ans);
    }
}
/**
 * 정리하자면
 * 1. 폭탄 모양 중복순열로 만들고
 * 2. grid를 순회하며 폭탄 모양이 발견되면 폭탄을 터친다
 * 3. 그리고 초토화된 곳의 갯수를 센다.
 */