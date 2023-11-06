import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        // 1. 입력으로 받은 n을 문자열로 변환
        String strN = Long.toString(n);
        int l = strN.length();
        
        // 2. Arrays.sort()를 활용하기 위해서 char배열을 만들고 삽입
        char[] arr = new char[l];
        for(int i = 0; i < l; i++)
            arr[i] = strN.charAt(i);
        Arrays.sort(arr);
        
        // 3. 오름차순 정렬을 위해서 tmp를 만들고 arr를 역으로 집어넣음
        String tmp = "";
        for(int i = 0; i < l; i++)
            tmp += arr[l - 1 - i];
        
        // 4. Long.parseLong()을 활용하여 long으로 변환
        answer = Long.parseLong(tmp);
        return answer;
    }
}