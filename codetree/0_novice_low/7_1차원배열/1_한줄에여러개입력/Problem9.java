import java.util.*;

public class Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;    // 통과한 학생의 수
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < 4; j++) {
                sum += sc.nextInt();
            }
            double avg = (double)sum / 4;
            if(avg >= 60) {
                cnt++;
                System.out.println("pass");
            } else
                System.out.println("fail");
        }
        System.out.println(cnt);
    }
}
