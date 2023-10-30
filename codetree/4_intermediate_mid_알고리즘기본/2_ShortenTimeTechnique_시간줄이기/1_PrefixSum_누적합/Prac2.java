public class Prac2 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {0, 0, 0, 0},
            {0, 1, 2, 3},
            {0, 3, 6, 2},
            {0, 7, 5, 5}
        };
        int[][] prefixSum = new int[4][4];

        for(int i = 1; i <= 3; i++)
            for(int j = 1; j <= 3; j++)
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i][j];

            // (1, 1) ~ (3, 3) 사이의 합 = 34
            System.out.println(prefixSum[3][3] - prefixSum[0][3] - prefixSum[3][0] + prefixSum[0][0]);

            // (1, 2) ~ (3, 2) 사이의 합 = 13
            System.out.println(prefixSum[3][2] - prefixSum[3][1] - prefixSum[0][2] + prefixSum[0][1]);
    }    
}
