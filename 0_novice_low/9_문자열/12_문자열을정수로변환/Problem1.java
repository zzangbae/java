import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        String str1 = A + B;
        String str2 = B + A;

        int str1Int = Integer.parseInt(str1);
        int str2Int = Integer.parseInt(str2);
        
        System.out.println(str1Int + str2Int);
    }
}
