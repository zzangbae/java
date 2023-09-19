import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = new String[10];
        for(int i = 0; i < 10; i++) {
            strArr[i] = sc.next();
        }
        
        // 홀수번째만 출력. 만약 짝수번째를 원한다면 i = 1로 초기값만 바꿔주면 된다.
        for(int i = 0; i < 10; i += 2) {
            System.out.println(strArr[i]);
        }
    }    
}
