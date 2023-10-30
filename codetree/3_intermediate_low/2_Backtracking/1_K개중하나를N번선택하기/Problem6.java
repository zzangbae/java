import java.util.*;

/**
 * 2명의 도둑
 * 17:06~17:51(45분)
 */
public class Problem6 {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 10;

    public static int n, m, c;  // m개의 열, c무게
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static ArrayList<Integer> weights = new ArrayList<>();

    public static int tmpAns1 = INT_MIN;
    public static int tmpAns2 = INT_MIN;
    public static int ans = INT_MIN;

    public static boolean isDuplicated(int x1, int y1, int x2, int y2) {
        // 다른행이면 겹치지 않는다.
        if(x1 != x2)
            return false;
        // 같은행인 경우
        for(int i = 0; i < m; i++) {
            if(y1 + i == y2)
                return true;
        }
        for(int i = 0; i < m; i++) {
            if(y2 + i == y1)
                return true;
        }
        return false;
    }
    
    // 해당 보물 조합을 들고갈 수 있는지 판단
    public static boolean possible() {
        int sum  = 0;
        for(int i = 0; i < weights.size(); i++) {
            sum += weights.get(i);
        }
        if(sum > c)
            return false;
        return true;
    }

    // 모아놓은 보물의 가치를 계산
    public static int calc() {
        int value = 0;
        for(int i = 0; i < weights.size(); i++) {
            value += weights.get(i) * weights.get(i);
        }
        return value;
    }

    // 하나의 도둑에 대해서 백트래킹
    // t는 두 도둑 중, 어느 도둑인지 알려줌, cnt가 m이면 종료
    public static void findMaxValue(int x, int y, int cnt, int t) {
        // 종료조건 - 무게 판단 해야함
        if(cnt == m) {
            // 무게 판단
            if(possible()) {
                if(t == 1)
                    tmpAns1 = Math.max(tmpAns1, calc());
                else
                    tmpAns2 = Math.max(tmpAns2, calc());
            }
            return;
        }

        // 재귀호출
        weights.add(grid[x][y + cnt]);
        findMaxValue(x, y, cnt + 1, t);
        weights.remove(weights.size() - 1);
        findMaxValue(x, y, cnt + 1, t);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // 물건 가치 : 무게 * 무게
        // 가치의 총합의 최댓값을 구하여라
        // 완탐에 백트래킹을 동시에 해야할 것 같음

        // (i, j)는 첫번째 도둑이 훔치는 맨 왼쪽
        // (k, l)은 두번째 도둑이 훔치는 맨 왼쪽
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= n - m; j++) {
                for(int k = 0; k < n; k++) {
                    for(int l = 0; l <= n - m; l++) {
                        // 겹침 판단
                        if(isDuplicated(i, j, k, l))
                            continue;
                        // 임의값 초기화
                        tmpAns1 = INT_MIN;
                        tmpAns2 = INT_MIN;
                        // 겹치지 않는다면 각각 백트래킹 수행
                        findMaxValue(i, j, 0, 1);
                        weights.clear();
                        findMaxValue(k, l, 0, 2);
                        weights.clear();
                        // tmpAns의 결과를 모아서 결과에 반영
                        ans = Math.max(ans, tmpAns1 + tmpAns2);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
