import java.util.HashSet;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        // 약수의 개수가 짝수인 수는 더하고
        // 약수의 개수가 홀수인 수는 빼
        // 제곱인 수들
        // 1~31의 제곱들을 저장하고 이 안에 있으면 빼기
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= 31; i++)
            set.add(i * i);
        
        for(int i = left; i <= right; i++) {
            if(set.contains(i))
                answer -= i;
            else
                answer += i;
        }
        return answer;
    }
}