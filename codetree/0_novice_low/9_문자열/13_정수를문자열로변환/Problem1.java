import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a + b;
        String cStr = Integer.toString(c);

        int cnt = 0;
        int cLen = cStr.length();
        for(int i = 0; i < cLen; i++) {
            if(cStr.charAt(i) == '1')
                cnt++;
        }
        
        System.out.println(cnt);
    }
}