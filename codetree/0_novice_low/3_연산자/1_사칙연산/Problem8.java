// 출력결과 25 - 다음 보기 중 프로그램을 실행할 때 오류가 발생하는 a, b값
public class Problem8 {
    public static void main(String[] args) {
        int a = 3;
        int b = 3;
        System.out.println((a % b) + " " + (a % (a % b)));
    }
    // a % b = 0이 되어서 % 뒷 대상이 0이 된다.
    // 즉, devideByZero오류인 셈이다.
}
