import java.util.Scanner;
// if조거눔ㄴ - 체질량지수
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double h = sc.nextInt();
        double Mh = h / 100;  
        int m = sc.nextInt();
        int bmi = (int)(m / (Mh * Mh));
        System.out.println(bmi);
        if(bmi >= 25)
            System.out.println("Obesity");
    }
}