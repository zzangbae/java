import java.util.Queue;
import java.util.LinkedList;

class Solution {
    // 전제: 모든 단어의 길이는 같다.
    public static boolean oneDiff(String a, String b) {
        int l = a.length();
        int cnt = 0;
        for(int i = 0; i < l; i++) {
            if(a.charAt(i) != b.charAt(i))
                cnt++;
            if(cnt >= 2)
                break;
        }
        if(cnt == 1)
            return true;
        else
            return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int l = words.length;
        // words에서 target이 몇번째 인덱스에 있는지 확인
        int ti = 100;
        for(int i = 0; i < l; i++) {
            if(words[i].equals(target)) {
                ti = i;
                break;
            }
        }
        // 만약 ti가 존재하지 않는다면 break;
        if(ti == 100)
            return 0;
        int[] visited = new int[l];
        // 한자리만 다르다면 큐에 집어넣는다.(해당 단어의 인덱스로)
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < l; i++) {
            String word = words[i];
            int cnt = 0;    // 몇 자리의 숫자가 다른지
            for(int j = 0; j < word.length(); j++) {
                if(begin.charAt(j) != word.charAt(j))
                    cnt++;
                // 만약 2자리 이상 다르다면 더이상 비교안해도됨
                if(cnt >= 2)
                    break;
            }
            // 한자리만 다르다면 큐에 넣기
            if(cnt == 1) {
                q.add(i);
                visited[i] = 1;
            }
        }
        // bfs돌리기
        while(!q.isEmpty()) {
            int wIdx = q.poll();
            String word = words[wIdx];
            // words를 순회한다.
            // 다음단어 조건 - visited값이 0이며, 한자리만 달라야함
            for(int i = 0; i < l; i++) {
                // 해당 단어는 제외
                if(wIdx == i)
                    continue;
                String next = words[i];
                // 다음단어가 가능하다면
                if(visited[i] == 0 && oneDiff(word, next)) {
                    q.add(i);
                    visited[i] = visited[wIdx] + 1;
                }
            }
        }
        
        // visited를 통해서 target에 도착했는지 확인
        answer = visited[ti];
        return answer;
    }
}