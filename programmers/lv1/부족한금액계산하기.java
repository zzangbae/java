class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long pay = 0;
        for(int i = 1; i <= count; i++)
            pay += i * price;
        answer = pay - money;
        // 비용이 부족하지 않으면 0반환
        if(answer < 0)
            answer = 0;
        return answer;
    }
}