import java.util.Scanner;
/*
 * 문자 배열 속 숫자 더하기
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String nStr = Integer.toString(n);
        int nLen = nStr.length();

        int result = 0;
        for(int i = 0; i < nLen; i++) {
            result += nStr.charAt(i) - '0';
        }

        System.out.println(result);
    }
}
