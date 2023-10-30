import java.util.*;

public class PrintXStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        draw(n);
    }

    public static void draw(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 || j == 1 || i == j || j == n - i + 1 || i == n || j == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}

/**
 * n = 5일 때 아래와 같이 출력
 *  출력
    *****
    ** **
    * * *
    ** **
    *****
 */
