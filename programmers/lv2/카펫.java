class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 노란색과 갈색으로 색칠된 격자의 갯수는 안다.
        // 전체 카펫의 크기는 기억하지 못함
        // 중앙에는 노라낵, 테두리 1줄은 갈색
        // 24, 24의 경우 생각해보자
        // x + y = 10
        // x * y = 24 이다. 즉, 안쪽 노란색은 6 x 4 -> 겉은 8 x 6(가로가 더 길다.)
        int x = 1;  // 노란색 세로
        int y;      // 노란색 가로
        // 8 ~ 5000
        while(true) {
            y = (brown - 4) / 2 - x;
            if(x * y == yellow) {
                break;
            }
            x++;
        }
        answer[0] = y + 2;
        answer[1] = x + 2;
        return answer;
    }
}