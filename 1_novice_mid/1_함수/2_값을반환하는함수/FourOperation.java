import java.util.*;

public class FourOperation {
    public static int plus(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int times(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();

        if(o == '+')
            System.out.print(a + " + " + c + " = " + plus(a, c));
        else if(o == '-')
            System.out.print(a + " - " + c + " = " + minus(a, c));
        else if(o == '*')
            System.out.print(a + " * " + c + " = " + times(a, c));
        else if(o == '/')
            System.out.print(a + " / " + c + " = " + divide(a, c));
        else
            System.out.print("False");
    }
}
