import java.util.Scanner;

class User {
    String id;
    int lv;

    public User() {
        this.id = "codetree";
        this.lv = 10;
    }

    public User(String id, int lv) {
        this.id = id;
        this.lv = lv;
    }
}

// 객체 생성 및 값 변경 - Next Level
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int lv = sc.nextInt();
        // 초기화
        User user = new User();
        System.out.println("user " + user.id + " lv " + user.lv);
        // 객체값 변경
        user.id = id;
        user.lv = lv;
        System.out.println("user " + user.id + " lv " + user.lv);
    }
}