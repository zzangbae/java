import java.util.*;

public class Problem2m {
    public static final int MAX_N = 100;

    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[] seq = new int[MAX_N];   // 한줄만 떼오기 위함
    
    public static boolean isHappySequence() {
        // 주어진 seq가 행복한 수열인지 판단
        int consecutiveCount = 1, maxCnt = 1;
        for(int i = 1; i < n; i++) {
            if(seq[i - 1] == seq[i])
                consecutiveCount++;
            else
                consecutiveCount = 1;
            
            maxCnt = Math.max(maxCnt, consecutiveCount);
        }

        return maxCnt >= m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int numHappy = 0;

        // 먼저 가로로 행복한 수열의 수를 센다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                seq[j] = grid[i][j];

            if(isHappySequence())
                numHappy++;
        }

        // 세로로 행복한 수열의 수를 센다.
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n; i++)
                seq[i] = grid[i][j];
            
            if(isHappySequence())
                numHappy++;
        }
        System.out.println(numHappy);
    }    
}
