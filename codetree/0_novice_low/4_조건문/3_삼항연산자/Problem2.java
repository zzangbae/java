import java.util.Scanner;
// 삼항연산자 - 삼항연산자
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        System.out.println(score == 100 ? "pass" : "failure");
    }
}