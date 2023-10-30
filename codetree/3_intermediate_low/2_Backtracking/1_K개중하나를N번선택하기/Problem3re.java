import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
 * 강력한 폭발 다시풀기
 * 12:13~12:33(20분)
 */
public class Problem3re {
    public static final int MAX_N = 20;
    public static final int MAX_B = 10; // 선택된 boom모양

    public static int n;
    public static boolean[][] boomed = new boolean[MAX_N][MAX_N];
    public static ArrayList<Pair> boomList = new ArrayList<>();
    public static int[] boomShape = new int[MAX_B];

    public static int ans;

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    // (x, y)에 t모양으로 폭탄이 터졌을 때 boomed에 영역처리
    public static void boom(int x, int y, int t) {
        int[] dx = {-2, -1, 0, 1, 2, -1, 0, 0, 1, 0, -1, -1, 0, 1, 1};
        int[] dy = {0, 0, 0, 0, 0, 0, 1, 0, 0, -1, -1, 1, 0, 1, -1};
        
        for(int i = 5 * (t - 1); i < 5 * t; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위 안에 있다면
            if(inRange(nx, ny)) {
                boomed[nx][ny] = true;
            }
        }
    }

    public static int calc() {
        // 1. boomed 초기화
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                boomed[i][j] = false;
        
        // 2. 폭탄을 순회하며 폭탄 영역 처리
        for(int i = 0; i < boomList.size(); i++) {
            int x = boomList.get(i).x;
            int y = boomList.get(i).y;
            boom(x, y, boomShape[i]);
        }

        // 3. boomed 순회하며 true영역 수 세기
        int cnt = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(boomed[i][j])
                    cnt++;
        
        return cnt;
    }

    public static void findMaxArea(int cnt) {
        // 종료조건
        if(cnt == boomList.size()) {
            ans = Math.max(ans, calc());
            return; // *** 이부분이 누락되서 밑에 호출에 문제생김
        }

        // 재귀호출
        for(int i = 1; i <= 3; i++) {
            boomShape[cnt] = i;
            findMaxArea(cnt + 1);
        }
    }

    public static void main(String[] args) {
        // 가장 폭발에 영향을 많이 받을 수 있는 영역
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                int boomPoint = sc.nextInt();
                if(boomPoint == 1)
                    boomList.add(new Pair(i, j));
            }

        findMaxArea(0);

        System.out.println(ans);
    }
}
