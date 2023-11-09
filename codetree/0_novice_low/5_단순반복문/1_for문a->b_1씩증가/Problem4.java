// 출력결과
public class Problem4 {
    public static void main(String[] args) {
        int a = 60, b = 0, i; 
        for (i = 1; i <= a; i++) {
            if (a % i == 0) b++;
        }
        System.out.println(b);  // 12
    }
}
