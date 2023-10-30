import java.util.*;

/**
 * 14:07~
 */
class Pair implements Comparable<Pair> {
    int x, y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Pair b) {
        if(x != b.x)
            return x - b.x;
        return y - b.x; // 양스일 경우 자리바꿈    
    }
}

/**
 * 사다리 타기 다시풀기
 * 14:07~
 */
public class Problem5re {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 11;

    public static int n, m;
    public static ArrayList<Pair> lines = new ArrayList<>();
    public static ArrayList<Pair> selectedLines = new ArrayList<>();

    public static int ans = INT_MAX;

    // 맨 위 라인부터 내려오면서 사람위치 교환
    public static boolean possible() {
        int[] num1 = new int[MAX_N];
        int[] num2 = new int[MAX_N];
        for(int i = 0; i < n; i++)
            num1[i] = num2[i] = i + 1;
        
        // 원래 사다리
        for(int i = 0; i < lines.size(); i++) {
            int idx = lines.get(i).y;   // 세로 위치
            int tmp = num1[idx];
            num1[idx] = num1[idx + 1];  // 다음으로 이동
            num1[idx + 1] = tmp;
        }

        // 바뀐 사다리
        for(int i = 0; i < selectedLines.size(); i++) {
            int idx = selectedLines.get(i).y;
            int tmp = num2[idx];
            num2[idx] = num2[idx + 1];
            num2[idx + 1] = tmp;
        }

        // 비교 - 만약 사람 위치가 다른 곳이 존재한다면
        for(int i = 0; i < n; i++) {
            if(num1[i] != num2[i])
                return false;
        }
        return true;
    }

    public static void findMinLines(int cnt) {
        // 종료조건
        if(cnt == m) {
            if(possible())
                ans = Math.min(ans, selectedLines.size());
            return;
        }

        // 재귀호출
        selectedLines.add(lines.get(cnt));
        findMinLines(cnt + 1);
        selectedLines.remove(selectedLines.size() - 1);
        findMinLines(cnt + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines.add(new Pair(b, a - 1));    // 라인 수
        }

        // lines.sort();    -> 이부분을 몰랐넹
        Collections.sort(lines);

        findMinLines(0);

        System.out.println(ans);
    }
}
