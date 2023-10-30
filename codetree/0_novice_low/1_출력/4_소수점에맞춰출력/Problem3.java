// 길이 단위 변환하기
// 1피트(ft) 30.48cm
// 1마일(mi) 160934cm
// cm로 변환하여 출력하기
public class Problem3 {
    public static void main(String[] args) {
        double ft = 9.2;
        double mi = 1.3;
        System.out.printf("%.1fft = %.1fcm%n", ft, ft * 30.48);
        System.out.printf("%.1fmi = %.1fcm", mi, mi * 160934);
    }
}