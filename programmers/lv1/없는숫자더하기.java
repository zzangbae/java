// 12:15~12:18(3분)
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        // 0~9 카운트 정렬을 만들고, 카운트 정렬로부터 없는 수를 찾아 더한다.
        int[] count = new int[10];
        int l = numbers.length;
        for(int i = 0; i < l; i++)
            count[numbers[i]]++;
        for(int i = 0; i < 10; i++)
            if(count[i] == 0)
                answer += i;
        
        return answer;
    }
}