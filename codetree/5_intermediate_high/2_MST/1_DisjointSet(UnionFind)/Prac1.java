// union-find1
public class Prac1 {

    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        uf[x] = y;
    }

    public static void union2(int x, int y) {
        x = find2(x);
        y = find2(y);
        uf2[x] = y;
    }

    public static int find(int x) {
        if(uf[x] == x)          // x가 루트노드라면
            return x;           // x값을 반환
        return find(uf[x]);     // x가 루트 노드가 아니라면, x의 부모인 uf[x]에서 더 탐색진행
    }

    public static int find2(int x) {
        if(uf2[x] == x)
            return x;
        int root_node = find2(uf2[x]);
        uf2[x] = root_node;
        return root_node;
    }

    public static int[] arr = new int[9];
    // uf:그룹 번호를 뜻함. 처음에는 전부 다른 그룹. 초기값 - 자기자신
    public static int[] uf = new int[9];
    public static int[] uf2 = new int[9];
    
    public static void main(String[] args) {
        for(int i = 0; i < 9; i++) {
            arr[i] = i;
            uf[i] = i;
            uf2[i] = i;
        }
        print(arr);
        print(uf);

        union(1, 3);
        print(uf);
        union(5, 6);
        print(uf);
        union(5, 1);
        print(uf);
        union(4, 1);
        print(uf);

        System.out.println("hihi");

        union2(1, 3);
        print(uf2);

        union2(5, 6);
        print(uf2);

        union2(5, 1);
        print(uf2);
        int answer = find2(5);  
        System.out.println("5번 노드의 루트노드: " + answer);
        print(uf2);
    }
}
