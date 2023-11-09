// 아래 코드의 출력결과
public class Problem3 {
    public static void main(String[] args) {
        int q = 0, s = 1, t = 1, i;
        for (i = 0; i < 4; i++) {
            q = s + t;
            t = s;
            s = q;
        }
        System.out.print(q);
    }
}
