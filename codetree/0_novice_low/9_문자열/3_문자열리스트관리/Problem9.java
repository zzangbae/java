import java.util.*;

public class Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strArr = new String[n];    // 자바는 동적할당 가능
        
        for(int i = 0; i < n; i++) {
            strArr[i] = sc.next();
        }
        char c = sc.next().charAt(0);
        int cnt = 0;
        int sumL = 0;
        for(int i = 0; i < n; i++) {
            if(strArr[i].charAt(0) == c) {
                cnt++;
                sumL += strArr[i].length();
            }
        }
        double avgL = (double)sumL / cnt;
        System.out.printf("%d %.2f", cnt, avgL);
    }    
}
