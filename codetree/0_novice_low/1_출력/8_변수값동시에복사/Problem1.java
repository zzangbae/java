// 변수 값 복사하기 - 변수값 동시에 복사하기
public class Problem1 {
    public static void main(String[] args) {
        int a = 1; int b = 2; int c = 3;
        a = b = c;
        System.out.println(a + " " + b + " " + c);
    }
}