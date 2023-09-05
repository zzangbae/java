import java.util.*;

public class LeapYear {
    public static boolean IsLeapYear(int y) {
        // 4의 배수가 아니라면 false
        if(y % 4 != 0)
            return false;
        
        // 여기까지오면 4의 배수. 100의 배수가 아니라면 윤년
        if(y % 100 != 0)
            return true;

        // 여기까지 오면 100의 배수. 400의 배수라면 윤년
        if(y % 400 == 0)
            return true;
        
        // 100의 배수이면서 400의 배수가 아니라면 윤년이 아니다.
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if(IsLeapYear(year))
            System.out.println("true");
        else
            System.out.println("false");
    }
}