import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n % 2 == 1 || (n % 2 == 0 && n >= 30))
            System.out.print("hi");
    }
}