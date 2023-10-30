// 합을 복사하기
public class Problem3 {
    public static void main(String[] args) {
        int a = 1; int b = 2; int c = 3;
        a = b = c = a + b + c;
        System.out.println(a + " " + b + " " + c);
    }
}