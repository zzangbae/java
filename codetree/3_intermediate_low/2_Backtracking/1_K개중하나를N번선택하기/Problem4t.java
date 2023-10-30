import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 겹치지 않게 선분 고르기
 */
public class Problem4t {
    public static final int MAX_N = 15;

    public static int n;
    public static Pair[] segments = new Pair[MAX_N];

    public static int ans;
    public static ArrayList<Pair> selectedSegs = new ArrayList<>();

    public static boolean overlapped(Pair seg1, Pair seg2) {
        int ax1 = seg1.x;
        int ax2 = seg1.y;

        int bx1 = seg2.x;
        int bx2 = seg2.y;

        // 두 선분이 셥치는지 여부는
        // 한 점이 다른 선분에 포함되는 경우로 판단이 가능하다.
        return (ax1 <= bx1 && bx1 <= ax2) || (ax1 <= bx2 && bx2 <= ax2) || (bx1 <= ax1 && ax1 <= bx2) || (bx1 <= ax2 && ax2 <= bx2);
    }

    // 2개씩 선택해서 선분이 겹치는가를 판단한다.
    public static boolean possible() {
        // 단 한쌍이라도 선분끼리 겹치면 안됨
        for(int i = 0; i < selectedSegs.size(); i++)
            for(int j = i + 1; j < selectedSegs.size(); j++)
                if(overlapped(selectedSegs.get(i), selectedSegs.get(j)))
                    return false;
        return true;
    }

    public static void findMaxSegments(int cnt) {
        if(cnt == n) {
            if(possible())
                ans = Math.max(ans, selectedSegs.size());
            return;
        }

        selectedSegs.add(segments[cnt]);
        findMaxSegments(cnt + 1);
        selectedSegs.remove(selectedSegs.size() - 1);
        findMaxSegments(cnt + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 선분을 배열로 저장 - 먼저 모든 공간 선언 및 초기화
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
 * 해설풀이
 * 1. 먼저 선분을 고르고
 * 2. 2개를 for문 조합으로 골라, 두 개의 선분이 겹치는 지를 판단
 * 3. 겹치는 것은 한점이 다른 선분에 포함되는 것으로 판단
 * 4. 겹치지 않을 경우, 최대 선분 수를 갱신하는지 판단
 */