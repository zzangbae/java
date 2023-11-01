// and, or 혼합 - 두 사람
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Aage = sc.nextInt();
        char Asex = sc.next().charAt(0);
        int Bage = sc.nextInt();
        char Bsex = sc.next().charAt(0);
        if(Aage >= 19 && Asex == 'M' || Bage >= 19 && Bsex == 'M')
            System.out.println(1);
        else
            System.out.println(0);
    }
}