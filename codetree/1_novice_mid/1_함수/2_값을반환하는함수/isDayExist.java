import java.util.*;

// 2021년 날짜의 유무(윤년 고려X)
public class isDayExist {
    // m번째 달의 마지막 날을 반환하는 함수
    public static int lastDayNumber(int m) {
        if(m == 2)
            return 28;
        if(m == 4 || m == 6 || m == 9 || m == 11)
            return 30;
        return 31;
    }

    // 윤년X일 때, m월 d일 이 존재하는지 여부 확인
    public static boolean judgeDay(int m, int d) {
        if(m <= 12 && d <= lastDayNumber(m))
            return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   // 1~20
        int d = sc.nextInt();   // 1~50

        if(judgeDay(m, d))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
