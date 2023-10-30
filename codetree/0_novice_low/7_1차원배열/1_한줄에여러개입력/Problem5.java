import java.util.*;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        for(int i = 0; i < 8; i++)
            sum += sc.nextDouble();
        System.out.printf("%.1f", sum / 8);
    }
}
