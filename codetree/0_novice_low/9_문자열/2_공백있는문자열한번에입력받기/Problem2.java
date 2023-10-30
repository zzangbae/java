import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String cc = sc.next();
        // 아래와 같이 받을 수도 있다.
        // char c = sc.next().charAt(0);
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == cc.charAt(0))
                cnt++;
        }

        System.out.println(cnt);
    }    
}
