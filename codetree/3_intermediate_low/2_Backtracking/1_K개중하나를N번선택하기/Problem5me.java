import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // 정렬함수
    @Override
    public int compareTo(Pair b) {
        if(x != b.x)
            return x - b.x;
        return y - b.y;
    }
}

/**
 * 사다리타기 해설풀이로 직접
 */
public class Problem5me {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 11;

    public static int n, m;
    public static ArrayList<Pair> lines = new ArrayList<>();
    public static ArrayList<Pair> selectedLines = new ArrayList<>();

    public static int ans = INT_MAX;

    public static boolean possible() {
        int[] num1 = new int[MAX_N];
        int[] num2 = new int[MAX_N];
        for(int i = 0; i < n; i++) {
            num1[i] = num2[i] = i;
        }

        for(int i = 0; i < lines.size(); i++) {
            int idx = lines.get(i).y;
            int tmp = num1[idx];
            num1[idx] = num1[idx + 1];
            num1[idx + 1] = tmp;
        }

        for(int i = 0; i < selectedLines.size(); i++) {
            int idx = selectedLines.get(i).y;
            int tmp = num2[idx];
            num2[idx] = num2[idx + 1];
            num2[idx + 1] = tmp;
        }

        for(int i = 0; i < n; i++) {
            if(num1[i] != num2[i])
                return false;
        }
        return true;
    }

    public static void findMinLines(int cnt) {
        // 종료조건
        if(cnt == m) {
            if(possible()) {
                ans = Math.min(ans, selectedLines.size());
            }
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
            lines.add(new Pair(b, a - 1));
        }

        Collections.sort(lines);

        findMinLines(0);

        System.out.println(ans);
    }
}
