import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char arr[] = new char[10];
        for(int i = 0; i < 10; i++)
            arr[i] = sc.next().charAt(0);
        
        for(int i = 9; i >= 0; i--)
            System.out.print(arr[i]);
    }
}
