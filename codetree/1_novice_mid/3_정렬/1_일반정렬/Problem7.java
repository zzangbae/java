import java.util.Scanner;
import java.util.Arrays;

// 순서를 바꾸었을 때 같은 단어인지 판별하기 -> 두 단어 속 알파벳이 동일한지 판단.(종류, 갯수 모두)
public class Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        String sortedS1 = new String(chars1);
        String sortedS2 = new String(chars2);
        if(sortedS1.equals(sortedS2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}