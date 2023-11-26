import java.util.Scanner;
import java.util.Arrays;

// 문자열 정렬 -> 오름차순
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String s2 = new String(chars);
        System.out.println(s2);
    }
}