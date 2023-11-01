import java.util.ArrayList;

class Solution {
    public static final int INT_MIN = Integer.MIN_VALUE;
    
    public static int l;
    public static ArrayList<Integer> idxs = new ArrayList<>();
    
    public static int result = INT_MIN;
    
    // 고른 인덱스로 최댓값을 구한다.
    public static int getSum(int[][] tri) {
        int r = 0;
        for(int i = 0; i < l; i++) {
            r += tri[i][idxs.get(i)];
        }
        return r;
    }
    
    // cnt: 층수, idx: 현재 층에서의 index
    public static void func(int cnt, int idx, int[][] tri) {
        // 종료조건 - arrayList에 있는 idx값들을 가져와서 더해주기
        if(cnt == l) {
            result = Math.max(result, getSum(tri));
            return;
        }
        // 재귀조건
        idxs.add(idx);  // 0 0 -> 7 3
        func(cnt + 1, idx, tri);
        idxs.remove(idxs.size() - 1);
        idxs.add(idx + 1);  // 0 1 -> 7 8
        func(cnt + 1, idx + 1, tri);
        idxs.remove(idxs.size() - 1);
    }
    
    public int solution(int[][] triangle) {
        int answer = 0;
        l = triangle.length;
        idxs.add(0);    // 맨 첫줄은 그냥 들어간다.
        func(1, 0, triangle);
        
        answer = result;
        return answer;
    }
}

// 층수가 500까지다.
// 즉 백트래킹으로 풀면 2^500 -> 시간초과
// 따라서 다른 방법으로 풀어야한다.
// 아마 dp?