import java.util.Scanner;

// 그래프의 싸이클
// n개의 정점(1번~n번)
// m개의 간선이 주어짐
// 몇번째에 간선이 추가되며 싸이클이 형성되었는지 출력
// 만약, 싸이클이 생기지 않았다면 "happy"출력
public class Problem5 {
    public static final int MAX_N = 100000;

    public static int n, m;
    public static int[] uf = new int[MAX_N + 1];

    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }

    public static int find(int x) {
        if(uf[x] == x)
            return x;
        return uf[x] = find(uf[x]);
    }

    public static void main(String[] args) {
        // 그래프에서 1번간선부터 시작해서 m번간선까지 순서대로 하나씩 놓으면서
        // 어느 간선이 생겼을 때 처음으로 그래프에 사이클이 생겼는지 알고 싶음
        // 싸이클이 생긴 지점을 구하는 프로그램을 작성(싸이클이 없다면 happy출력)
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++)
            uf[i] = i;

        // idea: 유니온 함수를 적용하기 전에 find가 같다면 싸이클을 이루는 것이다.
        // 이미 동일한 그룹에 있다면, 싸이클을 이루게 된다.
        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(find(x) == find(y)) {
                System.out.println(i);
                return;
            }
            union(x, y);
        }

        System.out.println("happy");
    }
}
/**
 * 해설풀이 및 아이디어 동일
 */