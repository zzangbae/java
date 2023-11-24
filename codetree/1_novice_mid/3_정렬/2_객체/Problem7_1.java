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
public class Problem7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Weather[] wList = new Weather[n];
        int rIdx = 0; 
        for(int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String wth = sc.next();
            wList[i] = new Weather(date, day, wth);
            if(!wth.equals("Rain"))
                continue;
            // 비 데이터를 처음 만났을 때
            if(rIdx == 0) {
                // 기존의 rIdx가 비가 아니었다면
                if(!wList[rIdx].wth.equals("Rain")) {
                    rIdx = i;
                    continue;
                }
                // 기존의 rIdx가 비였다면 -> 날짜비교
                else {
                    if(wList[rIdx].date.compareTo(date) > 0)
                        rIdx = i;
                }
            // 비 데이터를 처음만난게 아닐 때 -> 날짜비교
            } else {
                if(wList[rIdx].date.compareTo(date) > 0)
                    rIdx = i;
            } 
        }
        System.out.println(wList[rIdx].date + " " + wList[rIdx].day + " " + wList[rIdx].wth);
    }
}