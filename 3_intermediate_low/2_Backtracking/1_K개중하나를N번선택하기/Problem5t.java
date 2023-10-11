import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override   // true일 경우에 자리바꿈이 일어남 -> 오름차순으로
    public int compareTo(Pair b) {
        if(x != b.x)
            return x - b.x;
        return y - b.y;
    }
}

/**
 * 사다리 타기 해설풀이
 */
public class Problem5t {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 11;

    public static int n, m;
    
    public static ArrayList<Pair> lines = new ArrayList<>();
    public static ArrayList<Pair> selectedLines = new ArrayList<>();

    public static int ans = INT_MAX;
    
    // 처음상황, 선택한 가로줄만 사용했을 때의 상황을 시뮬레이션
    // 둘의 결과가 같은지 확인
    public static boolean possible() {
        // 1. 시작숫자를 세팅
        int[] num1 = new int[MAX_N + 1];
        int[] num2 = new int[MAX_N + 1];
        for(int i = 1; i <= n; i++)
            num1[i] = num2[i] = i;
        
        // 2. 위에서부터 순서대로 적혀있는
        // 가로줄에 대해 양쪽 번호에 해당하는 숫자를 바꿔줌
        for(int i = 0; i < lines.size(); i++) {
            int idx = lines.get(i).y;   // 세로줄
            int tmp = num1[idx];        // 세로줄 초기화(0자리에 1있음)
            num1[idx] = num1[idx + 1];
            num1[idx + 1] = tmp;
        }
        for(int i = 0; i < selectedLines.size(); i++) {
            int idx = selectedLines.get(i).y;
            int tmp = num2[idx];
            num2[idx] = num2[idx + 1];
            num2[idx + 1] = tmp;
        }

        // 3. 두 상황의 결과가 동일한지 판단
        for(int i = 0; i < n; i++)
            if(num1[i] != num2[i])
                return false;
        return true;
    }

    public static void findMinLines(int cnt) {
        // 종료조건
        if(cnt == m) {
            if(possible())
                ans = Math.min(ans, selectedLines.size());
            return;
        }

        // 재귀 호출
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
            int a = sc.nextInt();   // 세로 줄 번호
            int b = sc.nextInt();   // 라인 번호
            // 라인, 세로줄 번호 - 1;
            lines.add(new Pair(b, a - 1));
        }

        Collections.sort(lines);

        findMinLines(0);

        System.out.println(ans);
    }
}
/**
 * 백트래킹을 이용하는 문제지만,
 * 그 안에 사다리를 어떻게 처리할 것인가에 대한 논리구현이 중요한 문제
 */
