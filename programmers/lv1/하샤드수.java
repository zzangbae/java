class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        // x의 자릿수의 합으로 x가 나눠저야함
        int sum = 0;
        int xTmp = x;
        while(xTmp != 0) {
            sum += xTmp % 10 ;
            xTmp /= 10;
        }
        if(x % sum == 0)
            answer = true;
        else
            answer = false;
        return answer;
    }
}