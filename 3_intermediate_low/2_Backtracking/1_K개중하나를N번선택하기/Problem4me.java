import java.util.Scanner;
import java.util.ArrayList;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 겹치지 않게 선분 고르기 : 해설풀이 직접하기
 */
public class Problem4me {
    public static final int MAX_N = 15;

    public static int n;
    public static Pair[] segments = new Pair[MAX_N];
    public static ArrayList<Pair> selectedSegs = new ArrayList<>();

    public static int ans;

    public static boolean overLapped(Pair p1, Pair p2) {
        int ax1 = p1.x;
        int ax2 = p1.y;

        int bx1 = p2.x;
        int bx2 = p2.y;

        // 한 점이 다른 선분에 포함되어 있으면 겹친 것이다.
        return (bx1 >= ax1 && bx1 <= ax2) || (bx2 >= ax1 && bx2 <= ax2) || (ax1 >= bx1 && ax1 <= bx2) || (ax2 >= bx1 && ax2 <= bx2);
    }

    public static boolean possible() {
        for(int i = 0; i < selectedSegs.size(); i++) {
            for(int j = i + 1; j < selectedSegs.size(); j++) {
                if(overLapped(selectedSegs.get(i), selectedSegs.get(j)))
                    return false;
            }
        }
        return true;
    }

    public static void findMaxSegments(int cnt) {
        // 종료조건
        if(cnt == n) {
            if(possible())
                ans = Math.max(ans, selectedSegs.size());
            return;
        }

        // 재귀호출
        selectedSegs.add(segments[cnt]);
        findMaxSegments(cnt + 1);
        selectedSegs.remove(selectedSegs.size() - 1);
        findMaxSegments(cnt + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++)
            segments[i] = new Pair(0, 0);
        
        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Pair(x1, x2);
        }

        findMaxSegments(0);

        System.out.println(ans);
    }
}

/**
 * 드는 생각 : 나처럼 푸는 경우, count정렬이 너무 컸을 때에 문제가 생길 수도 있을 것 같다.
 * -> 즉, 메모리 초과가 일어날 수도 있을 것이다.
 */
