// 실수 입력 - 길이 단위 환산하기
// ft를 cm으로 변환 1ft = 30.48cm
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        System.out.printf("%.1f", n * 30.48);
    }
}