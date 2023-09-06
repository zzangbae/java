import java.util.Scanner;

// 그 계절, 그 날
public class CheckSeason {
    public static boolean isLeapYear(int y) {
        if(y % 4 != 0)
            return false;
        
        if(y % 100 != 0)
            return true;
        
        if(y % 400 == 0)
            return true;
        
        return false;
    }

    public static boolean isExistDay(int y, int m, int d) {
        // 인덱스가 월
        int[] numsOfDays = new int[]{0, 31, 0, 31, 30, 31, 30 , 31, 31, 30, 31, 30, 31};
    
        // 윤년처리 -> 3항 연산자로 처리
        numsOfDays[2] = isLeapYear(y) ? 29 : 30;

        return d <= numsOfDays[m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        // y년 m월 d월의 존재여부에 따라 판단
        if(!isExistDay(y, m, d)) {
            System.out.print("-1");
            System.exit(0); // 메인 메서드 종료
        }

        // 여기까지 오면 존재하는 것
        if(3 <= m && m <= 5) {
            System.out.print("Spring");
        }
        else if(6 <= m && m <= 8) {
            System.out.print("Summer");
        }
        else if(9 <= m && m <= 11) {
            System.out.print("Fall");
        }
        else {
            System.out.print("Winter");
        }
    }
}
