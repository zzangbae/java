public class Test {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        a = b;  // a = 3
        b = 6;  // b = 6
        System.out.println(a + " " + b);    // a는 변경되지 않는다.
    }
}