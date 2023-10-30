// 데이터 교환
public class Problem3t {
    public static void main(String[] args) {
        int a = 5; int b = 6; int c = 7;
        int tmp = a;
        a = c;
        c = b;
        b = tmp;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}