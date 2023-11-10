class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int l = signs.length;
        for(int i = 0; i < l; i++) {
            if(signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }
        return answer;
    }
}