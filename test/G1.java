import java.util.*;

public class G1 {
    public List<String> wordBreak(String s, String[] word_dict) {
        // Set으로 변환
        Set<String> dict = new HashSet<>(Arrays.asList(word_dict));
        int len = s.length();

        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        int[] prevIdx = new int[len + 1];

        for(int end = 1; end <= len; end++) {
            for(int start = end - 1; start >= 0; start--) {
                String word = s.substring(start, end);
                if(dict.contains(word) && dp[start]) {
                    dp[end] = true;
                    prevIdx[end] = start;
                    break;
                }
            }
        }

        List<String> result = new ArrayList<>();
        if(dp[len]) {
            int idx = len;
            while(idx > 0) {
                int prev = prevIdx[idx];
                result.add(s.substring(prev, idx));
                idx = prev;
            }
            Collections.reverse(result);
        }

        return result;
    }

    public int solution(String s, String[] word_dict) {
        int answer = 0;
        List<String> result = wordBreak(s, word_dict);
        answer = result.size();
        return answer;
    }
}
