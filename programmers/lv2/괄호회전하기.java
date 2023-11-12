// 12:19~12:33(14분)
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int l = s.length();
        // 홀수면 애초에 되지 않는다.
        if(l % 2 == 1)
            return 0;
        // 왼쪽으로 이동시키면서 판단
        for(int x = 0; x < l; x++) {
            // 스택을 생성 판단하기
            Stack<Character> stack = new Stack<>();
            for(int i = x; i < x + l; i++) {
                char c;
                if(i >= l)
                    c = s.charAt(i - l);
                else
                    c = s.charAt(i);
                if(stack.isEmpty())
                    stack.add(c);
                // 스택이 비어있지 않은 경우
                else {
                    if(c == ')' && stack.peek() == '(')
                        stack.pop();
                    else if(c == ']' && stack.peek() == '[')
                        stack.pop();
                    else if(c == '}' && stack.peek() == '{')
                        stack.pop();
                    else
                        stack.add(c);
                    }
            }
            // 스택이 비어있다면 answer++
            if(stack.isEmpty())
                answer++;
        }        
        return answer;
    }
}