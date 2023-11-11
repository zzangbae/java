import java.util.HashSet;

class Solution {
    
    // s: 시작점, w: 연속 부분 수열 길이
    public static int findSum(int s, int w, int[] elements) {
        int sum = 0;
        int l = elements.length;
        for(int i = s; i < s + w; i++) {
            // 만약 범위를 벗어났다면 안벗어나게
            if(i >= l) {
                sum += elements[i - l];
            } else {
                sum += elements[i];
            }
        }
        return sum;
    }
    
    public int solution(int[] elements) {
        int answer = 0;
        int l = elements.length;
        HashSet<Integer> hSet = new HashSet<>();
        // 길이 1 ~ l까지
        for(int w = 1; w <= l; w++) {
            // 모든 인덱스를 시작으로 하는 부분합을 구해서 넣기
            for(int i = 0; i < l; i++) {
                hSet.add(findSum(i, w, elements));
            }
        }
        answer = hSet.size();
        
        return answer;
    }
}