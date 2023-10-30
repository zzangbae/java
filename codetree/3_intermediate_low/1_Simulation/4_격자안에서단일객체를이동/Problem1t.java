import java.util.*;

public class Problem1t {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 100;

    public static int n;
    public static int currX, currY; // 현재위치
    public static int[][] a = new int[MAX_N + 1][MAX_N + 1];

    // 방문하게 되는 숫자들을 담을 곳
    public static ArrayList<Integer> visitedNums = new ArrayList<>();

    // 범위가 격자 안에 들어가는지
    public static boolean inRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }

    public static boolean canGo(int x, int y, int currNum) {
        return inRange(x, y) && a[x][y] > currNum;
    } 

    public static boolean simulate() {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for(int i = 0; i < 4; i++) {
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];

            if(canGo(nextX, nextY, a[currX][currY])) {
                currX = nextX;
                currY = nextY;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        currX = sc.nextInt();
        currY = sc.nextInt();

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();
        
        // 초기 위치 적혀있는 값 집어넣기
        visitedNums.add(a[currX][currY]);

        while(true) {
            boolean greaterNumberExist = simulate();

            if(!greaterNumberExist)
                break;
            
            visitedNums.add(a[currX][currY]);
        }

        // 출력
        for(int i = 0; i < visitedNums.size(); i++)
            System.out.print(visitedNums.get(i) + " ");
    }    
}
