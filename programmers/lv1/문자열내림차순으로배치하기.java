import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        // 문자열을 문자배열로 바꾸기
        char[] cl = s.toCharArray();
        
        // Arrays를 활용해 오름차순 정렬
        Arrays.sort(cl);
        
        // 뒤에서부터 answer에 추가하기
        int l = cl.length;
        for(int i = l - 1; i >= 0; i--)
            answer += cl[i];
        return answer;
    }
}