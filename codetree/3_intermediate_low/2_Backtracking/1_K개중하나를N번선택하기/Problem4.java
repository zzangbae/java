import java.util.*;

class Pair {
    int x1, x2;
    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
/*
 * 겹치지 않게 선분 고르기
 * 11:50~12:21(31분)
 */
public class Problem4 {
    public static final int MAX_X = 1000;
    
    public static int n;
    public static ArrayList<Pair> lines = new ArrayList<>();
    public static ArrayList<Pair> included = new ArrayList<>();
    public static int[] count = new int[MAX_X + 1];
    
    public static int ans;

    public static boolean isDuplicated() {
        // 1. count정렬 비우기
        for(int i = 1; i <= 1000; i++) {
            count[i] = 0;
        }

        // 2. count정렬 채우기 with included
        for(int i = 0; i < included.size(); i++) {
            int x1 = included.get(i).x1;
            int x2 = included.get(i).x2;
            for(int x = x1; x <= x2; x++) {
                count[x]++;
            }
        }

        for(int i = 1; i <= 6; i++) {
            System.out.print(count[i]);
        }
        System.out.println();
        System.out.println("---------");

        // 3. count정렬 판단하기 -> 1을 초과하는 곳이 있다면 겹치는 것이다.
        for(int i = 1; i <= 1000; i++) {
            if(count[i] > 1)
                return true;
        }
        return false;
    }

    public static void findMaxLines(int c) {
        // 종료조건
        if(c == n) {
            // 겹치지 않는다면, included의 갯수가 선분의 갯수, max를 통해서 갱신
            if(!isDuplicated())
                ans = Math.max(ans, included.size());
            return;
        }
        
        // 재귀호출
        included.add(lines.get(c));
        findMaxLines(c + 1);
        included.remove(included.size() - 1);
        findMaxLines(c + 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            lines.add(new Pair(x1, x2));
        }
        
        findMaxLines(0);
        
        // 끝점 공유 역시 겹친 것이다.
        // 겹치지 않게 가장 많은 수의 선분을 고르는 프로그램
        // 1. 백트래킹을 통해서 선분을 고른다.ㅇㅇ
        // 2. 해당 선분으로 이루어진 counting 정렬을 만든다.
        // 3. 겹침 여부를 판단한다.
        // 4. 겹치지 않을 경우, 최대 선분의 수를 갱신시킨다.
        // 5. 단, counting정렬은 매번 새롭게 해준다.
        System.out.println(ans);
    }    
}
