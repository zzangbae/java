import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int l = tangerine.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        // hashmap에 귤 크기 - 해당 크기의 귤 갯수 저장
        for(int i = 0; i < l; i++) {
            int size = tangerine[i];
            if(map.containsKey(size)) {
                int cnt = map.get(size);
                map.put(size, cnt + 1);
            } else {
                map.put(size, 1);
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // pq에 저장 - 큰 것부터 갯수만 저장하면 된다.
        Set<Integer> keySet = map.keySet();
        for(int key : keySet) {
            int cnt = map.get(key);
            pq.add(-cnt);   // 음으로 넣어야 절대값이 가장 큰 값부터 나오게된다.
        }
        
        // pq에서 하나씩 꺼내면서 측정
        while(!pq.isEmpty()) {
            answer++;
            int cnt = -pq.poll();
            k -= cnt;   // k에서 cnt갯수만큼 빼줌
            if(k <= 0)
                break;
        }
        
        return answer;
        
    }
}