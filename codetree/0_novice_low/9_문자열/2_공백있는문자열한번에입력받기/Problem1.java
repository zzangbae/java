import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 2; i <= 9; i++)
            System.out.print(s.charAt(i));
    }
}
