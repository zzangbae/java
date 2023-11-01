// and, or 혼합 - 좀 더 어려운 수학 점수
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int am = sc.nextInt();
        int ae = sc.nextInt();
        int bm = sc.nextInt();
        int be = sc.nextInt();
        if(am > bm)
            System.out.println("A");
        else if(am < bm)
            System.out.println("B");
        else if(ae > be)
            System.out.println("A");
        else
            System.out.println("B");

        // 아래와 같이 표현가능
        if(am > bm || (am == bm) && ae > be)
            System.out.println("A");
        else
            System.out.println("B");
    }
}