// 9:33~9:39
class Solution {
    public int[] solution(int[] arr) {
        int l = arr.length;
        // 애초에 길이가 1이면 [-1]을 반환한다.
        if(l == 1)
            return new int[]{-1};
        int[] answer = new int[l - 1];
        
        // 최솟값을 찾는다.
        int idx = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < l; i++) {
            if(arr[i] < min) {
                min = arr[i];
                idx = i;
            }
        }
        
        // 해당 인덱스를 제외하고 결과에 넣기
        int w = 0;
        for(int i = 0; i < l; i++) {
            if(i == idx)
                continue;
            answer[w] = arr[i];
            w++;
        }
        return answer;
    }
}