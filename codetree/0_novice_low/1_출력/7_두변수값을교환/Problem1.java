// 변수 값 교체하기 3 => temp를 이용한 두 변수값 교환
public class Problem1 {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println(a);
        System.out.println(b);
    }
}