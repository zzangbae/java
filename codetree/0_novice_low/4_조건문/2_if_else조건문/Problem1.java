import java.util.Scanner;

// if else 조건문 - 시험 통과 여부 확인하기
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n >= 80)
            System.out.println("pass");
        else
            System.out.println(80 - n + " more score");
    }
}