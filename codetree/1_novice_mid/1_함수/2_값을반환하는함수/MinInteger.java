import java.util.*;

public class MinInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int result = findMin3(a, b, c);
        int result2 = min(a, b, c);
        System.out.println(result);
        System.out.println(result2);
    }

    public static int findMin3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    // 정답 코드
    public static int min(int a, int b, int c) {
        int minVal = a;
        if(minVal > b)
            minVal = b;
        if(minVal > c)
            minVal = c;
        
            return minVal;
    }
}
