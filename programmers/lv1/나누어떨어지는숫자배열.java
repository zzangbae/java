import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int l = arr.length;
        int[] tmpArr = new int[l];
        int cnt = 0;    // answer의 인덱스
        for(int i = 0; i < l; i++) {
            if(arr[i] % divisor == 0) {
                tmpArr[cnt] = arr[i];
                cnt++;
            }
        }
        if(cnt == 0)
            answer = new int[]{-1};
        else {
            answer = new int[cnt];
            for(int i = 0; i < cnt; i++)
                answer[i] = tmpArr[i];
            Arrays.sort(answer);
        }
        return answer;
    }
}