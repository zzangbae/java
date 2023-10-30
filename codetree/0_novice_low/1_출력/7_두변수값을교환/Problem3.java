// 데이터 교환
public class Problem3 {
    public static void main(String[] args) {
        int a = 5; int b = 6; int c = 7;
        int tmpb = b;
        int tmpa = a;
        int tmpc = c;
        b = tmpa;
        c = tmpb;
        a = tmpc;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    // 사실 교환 순서만 잘맞춰주면 tmp를 하나만 활용해도 된다.
    // Problem3t 참고
}