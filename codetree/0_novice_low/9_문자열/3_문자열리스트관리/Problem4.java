import java.util.*;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int l = 0;  // 모든 문자열의 길이의 합
        int cnt = 0;    // 문자열 중 첫 번째 문자로 'a'가 몇 번 나왔는지
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            l += s.length();
            if(s.charAt(0) == 'a')
                cnt++;
        }
        System.out.print(l + " " + cnt);
    }    
}
