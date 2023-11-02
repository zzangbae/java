import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = -1;
        // 짝지어 제거하기를 수행했을 때, 모든 문자를 제거할 수 있으면 1을 반환 -> 100만자.
        // O(n) or O(logN)으로 풀 수 있음
        // Stack을 이용해보자
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(st.isEmpty()) {
                st.add(c);
            } else {
                if(st.peek() == c) {
                    st.pop();
                } else {
                    st.add(c);
                }
            }
        }
        if(st.isEmpty())
            answer = 1;
        else
            answer = 0;
        return answer;
    }
}