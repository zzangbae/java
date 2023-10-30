public class funcProblem {
    // 2차원 배열 선언
    public static int[][] a = new int[][]{
        {2, 0, 1, 5},
        {0, 4, 1, 1},
        {1, 4, 0, 0}
    };
    
    public static void f(int b) {
        int i;
        for(i = 0; i < 4; i++) {
            a[b][i] = a[(b + 1) % 3][(i + 1) % 4];
        }
    }
    
    public static void main(String[] args) {
        int i, tot = 0;
        f(1);
        f(2);
        f(0);
        for(i = 0; i < 3; i++) {
            tot = tot + a[i][(i + 1) % 4];
        }
        System.out.println(tot);
    }    
}
