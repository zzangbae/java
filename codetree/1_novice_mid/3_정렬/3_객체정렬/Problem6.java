import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class User {
    String name;
    int h, w;

    public User(String name, int h, int w) {
        this.name = name;
        this.h = h;
        this.w = w;
    }
}

// 키, 몸무게를 기준으로 정렬 - 키를 기준으로 오름차순, 동일한 경우, 몸무게가 더 크게
public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        User[] users = new User[n];
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int h = sc.nextInt();
            int w = sc.nextInt();
            users[i] = new User(name, h, w);
        }

        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                if(a.h == b.h)
                    return b.w - a.w;
                return a.h - b.h;
            }
        });

        for(int i = 0; i < n; i++)
            System.out.println(users[i].name + " " + users[i].h + " " + users[i].w);
    }
}