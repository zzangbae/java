// 출력결과
public class Problem5 {
    public static void main(String[] args) {
        int n = 128, i, result = 0; 
        for (i = 1; i < n; i++) {
            if (n % i == 0) { 
                result += i;
            } 
        }
        // result = 127
    }
}
