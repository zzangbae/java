import java.util.Scanner;
import java.util.Arrays;

class User implements Comparable<User> {
    String name;
    int h, w;

    public User(String name, int h, int w) {
        this.name = name;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(User u) {
        return this.h - u.h;
    }
}

// 하나의 기준으로 객체 정렬 - 키를 기준으로 정렬
public class Problem1 {
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

        Arrays.sort(users);

        for(int i = 0; i < n; i++)
            System.out.println(users[i].name + " " + users[i].h + " " + users[i].w);
    }
}