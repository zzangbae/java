import java.util.Scanner;
import java.util.HashSet;

// 트리 완성
// 그래프가 주어짐 -> 이를 트리로 만들고자함(트리:싸이클없는 연결그래프)
// 연산: 두 노드 사이 간선을 끊거나, 간선을 추가함
// 그래프를 트리로 만들기 위한 연산의 최솟값
public class Problem6 {
    public static int MAX_N = 100000;

    public static int n, m;
    public static int[] uf = new int[MAX_N + 1];
    public static int cnt = 0;  // 싸이클이 몇개가 있는지 담기는 변수
    public static HashSet<Integer> set = new HashSet<>();

    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        if(X == Y)
            cnt++;  // 나중에 싸이클 갯수만큼 연산을 추가해준다.
        uf[X] = uf[Y];
    }

    public static int find(int x) {
        if(uf[x] == x)
            return x;
        return uf[x] = find(uf[x]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++)
            uf[i] = i;

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(x, y);
        }

        // 전체 find를 돌리고. set에 값을 집어넣어 집합의 갯수를 센다.
        for(int i = 1; i <= n; i++) {
            set.add(find(i));
        }
        // 집합 갯수 - 1이 추가연산이 들어가야하는 집합의 갯수이다.
        System.out.println(set.size() - 1 + cnt);
    }
}