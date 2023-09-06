import java.util.*;

// 함수를 이용한 온전수 판별
public class PerfectNum {
    // 온전수 판별 : top-down 구조로 수행
    public static boolean judgeNumber(int n) {
        if(n % 2 == 0)
            return false;
        else if(n % 10 == 5)
            return false;
        else if(n % 3 == 0 && n % 9 == 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();   // 1~100
        int b = sc.nextInt();   // 1~100

        int cnt = 0;
        for(int i = a; i <= b; i++)
            if(judgeNumber(i))
                cnt++;
        
        System.out.print(cnt);
    }
}
