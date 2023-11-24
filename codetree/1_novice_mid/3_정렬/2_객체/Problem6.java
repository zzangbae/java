import java.util.Scanner;

class User {
    String name, addr, city;
    
    public User(String name, String addr, String city) {
        this.name = name;
        this.addr = addr;
        this.city = city;
    }
}

// 객체 - 사는 지역 - compareTo() 메서드 활용
public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        User[] users = new User[n];
        int maxIdx = 0;
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            String addr = sc.next();
            String city = sc.next();
            users[i] = new User(name, addr, city);

            if(name.compareTo(users[maxIdx].name) > 0)
                maxIdx = i;
        }

        System.out.println("name " + users[maxIdx].name);
        System.out.println("addr " + users[maxIdx].addr);
        System.out.println("city " + users[maxIdx].city);
    }
}