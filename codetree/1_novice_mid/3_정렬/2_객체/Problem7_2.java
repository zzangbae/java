import java.util.Scanner;

class Weather {
    String date, day, wth;

    public Weather(String date, String day, String wth) {
        this.date = date;
        this.day = day;
        this.wth = wth;
    }
}

// 객체 - 비오는 날 - 가장 근 시일 내 비가 오는 날짜
public class Problem7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Weather[] wList = new Weather[n];
        Weather ans = new Weather("9999-99-99", "", "");    // 이렇게 줘버리면 훨씬 쉬움
        for(int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String wth = sc.next();
            wList[i] = new Weather(date, day, wth);
            if(wth.equals("Rain"))
                if(ans.date.compareTo(date) > 0)
                    ans = wList[i];
        }
        System.out.println(ans.date + " " + ans.day + " " + ans.wth);
    }
}
