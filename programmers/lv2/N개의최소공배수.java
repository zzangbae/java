class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int l = arr.length;
        int g = 1;
        // 나눠지는 것만 나눠가면서 하면 되는듯?
        while(true) {
            int cnt = 0;
            int tmp = 0;
            
            // 2부터 모든 요소를 나눠본다.
            for(int i = 2; i <= 100; i++) {
                for(int j = 0; j < l; j++){
                    if(arr[j] % i == 0)
                        cnt++;
                }
                // 상호 공약수가 발견되면 break;
                if(cnt >= 2) {
                    tmp = i;
                    break;
                }
            }
            // tmp가 0이라면 더이상 상호공약수가 없는 것
            if(tmp == 0)
                break;
            
            // 상호공약수로 나누어지면 나눠주기
            for(int i = 0; i < l; i++) {
                if(arr[i] % tmp == 0 && arr[i] >= tmp)
                    arr[i] /= tmp;
            }
            g *= tmp;   // g에 곱해주기
        }
        answer = g;
        for(int i = 0; i < l; i++)
            answer *= arr[i];
        return answer;
    }
}