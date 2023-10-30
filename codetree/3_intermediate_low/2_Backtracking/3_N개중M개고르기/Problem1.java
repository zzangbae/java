import java.util.*;

/**
 * n개 중 m개 뽑기
 */
public class Problem1 {
    public static int n, m;
    public static ArrayList<Integer> l = new ArrayList<>();
    
    public static void print(ArrayList<Integer> l) {
        for(int i : l) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void combination(ArrayList<Integer> l, int t,int r) {
        if(l.size() == m) {
            print(l);
            return;
        }
        for(int i = t; i <= n; i++) {
            l.add(i);
            combination(l, i + 1, r + 1);
            l.remove(l.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combination(l, 1, 0);
    }
}
