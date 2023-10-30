import java.util.*;

public class PrintNString {

    public static void printString(int n) {
        for(int i = 0; i < n; i++)
            System.out.println("12345^&*()_");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowNum = sc.nextInt();
        printString(rowNum);
    }
}
