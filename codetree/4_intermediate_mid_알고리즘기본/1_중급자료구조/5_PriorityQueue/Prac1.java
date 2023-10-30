import java.util.PriorityQueue;

public class Prac1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(-2);
        pq.add(-9);
        pq.add(-5);

        System.out.println(-pq.peek()); // 최솟값(-9)를 반환. but -를 붙여 9가 반환
        pq.poll();  // 최솟값 반환 동시에 삭제
        System.out.println("우선순위 큐 사이즈: " + pq.size());  // 2
        while(!pq.isEmpty()) {
            System.out.println(-pq.poll()); // 5 2 출력
        }
    }
    /**
     * 우선순위 큐 : 항상 우선순위가 높은 데이터에만 관심 있음
     * 우선순위 높은 데이터만 먼저 나갈 수 있는 형태의 자료구조
     * 기억할 메서드
     * 1. add(E)
     * 2. size()
     * 3. isEmpty()
     * 4. peek()    // 최솟값 반환
     * 4. poll()    // 최솟값 반환 & 삭제
     */
}