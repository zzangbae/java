// 출력결과 62 - 다음 프로그램의 출력 결과
public class Problem9 {
    public static void main(String[] args) {
        int a = 1; 
        double b = 1.3; 
        double c;
        c = a + b;
        System.out.printf("%.2f", c);
    }
}
// a와 b의 합은 2.3이고 double형
// 이 값이 c에 들어가고
// 소수점 둘 째자리까지 반올림해서 출력 -> 2.30
