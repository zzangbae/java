import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 3;
        while(i <= n) {
            System.out.print(i + " ");
            i += 3;
        }
    }
}