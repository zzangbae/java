import java.util.Scanner;

public class Problem4t {
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
        
        for(int i = 2; i <= n; i++) {
            int I = find(i);
            if(I != find(1)) {
                System.out.println(1 + " " + i);
                break;
            }
        }
    }
}

/**
 * t의 풀이는 나의 풀이와 아이디어는 비슷하다.
 * 하지만, 다른 집합을 찾는 과정에서 find를 씀으로써 계산을 더 줄였다.
 */