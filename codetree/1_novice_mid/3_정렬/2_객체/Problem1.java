import java.util.Scanner;

class Secret {
    String code, place;
    int time;

    public Secret(String code, String place, int time) {
        this.code = code;
        this.place = place;
        this.time = time;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        String place = sc.next();
        int time = sc.nextInt();
        Secret secret = new Secret(code, place, time);
        System.out.println("secret code : " + secret.code);
        System.out.println("meeting point : " + secret.place);
        System.out.println("time : " + secret.time);
    }
}