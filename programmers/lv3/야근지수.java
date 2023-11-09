import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        // 야근 피로 : 야근 시작한 시점, 남을일의 작업량의 제곱
        // n시간동안 야근 피로도를 최소화
        // 1시간동안 1만큼 일처리
        int l = works.length;
        // 1. pq에 모든 값을 넣는다.(최대 큐)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < l; i++)
            pq.add(-works[i]);
        
        // 2. 최댓값을 1씩 낮춘다.(n번 수행)
        for(int i = 0; i < n; i++) {
            int max = -pq.poll();
            // 2-2. 만약 최대값이 0이라면 끝낸다.
            if(max == 0) {
                pq.add(0);  // 다시 0을 넣어주고 끝내기.
                break;
            }
            max -= 1;
            pq.add(-max);
        }
        
        // 3. pq에서 하나씩 꺼내면서 야근 피로도를 구한다.
        for(int i = 0; i < l; i++) {
            int max = -pq.poll();
            if(max == 0)
                break;
            answer += (long)max * (long)max;
        }
        
        return answer;
    }
}