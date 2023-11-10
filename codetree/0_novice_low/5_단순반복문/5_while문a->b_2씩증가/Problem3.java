import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        while(a <= b) {
            System.out.print(a + " ");
            a += 2;
        }
    }
}