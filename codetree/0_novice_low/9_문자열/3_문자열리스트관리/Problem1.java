import java.util.*;

/**
 * 문자열의 특정 위치 찾기
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char c = sc.next().charAt(0);
        
        String[] arr = new String[]{"apple", "banana", "grape", "blueberry", "orange"};
        int cnt = 0;        // cf-배열의 크기는 배열.length로 바로 찾을 수 있음(멤버변수)
        
        for(int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if(s.charAt(2) == c || s.charAt(3) == c) {
                System.out.println(s);
                cnt++;
            }
        }
        System.out.println(cnt);
    }    
}
