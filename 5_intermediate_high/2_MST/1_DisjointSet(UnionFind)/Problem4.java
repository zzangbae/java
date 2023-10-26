import java.util.Scanner;

// 정점 연결하기
// n - 1개의 간선이 n개의 노드사이에서 연결(모든 노드는 연결됨)
// 1개를 뺌. 이 때, 1개의 간선을 추가해서 다시 모든 노드를 연결하고자 함
public class Problem4 {
    public static final int MAX_N = 100000;

    public static int n;
    public static int[] uf = new int[MAX_N + 1];

    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }

    public static int find(int x) {
        if(uf[x] == x)
            return x;
        return uf[x] = find(uf[x]); // 재귀적으로 루트노드를 찾아서 uf에 갱신시킴
    }

    public static void main(String[] args) {
        // 간선을 하나 추가해 모든 정점이 연결된 그래프로 복원을 하고 싶음
        // 모든 정점이 연결되도록 하는 간선을 구하는 프로그램작성
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            uf[i] = i;
        
        // n - 2개의 간선
        for(int i = 1; i <= n - 2; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(x, y);
        }
        
        // 모든 값을 루트로 보냄
        for(int i = 1; i <= n; i++)
            find(i);

        // 무조건 1이 포함된 집합과 1이 포함되지 않는 집합으로 구성되어 있을 것이다.
        // 따라서 uf[1]값과 다른 값이 나오면 바로 그 x가 정답이 된다.
        int k = uf[1];
        int w = 0;
        for(int i = 2; i <= n; i++)
            if(k != uf[i]) {
                w = i;
                break;  // 사전순으로 가장 빨라야 하므로, 찾으면 break
            }
        System.out.println(1 + " " + w);
    }
}