import java.util.Scanner;

class Boom {
    String code, color;
    int time;

    public Boom(String code, String color, int time) {
        this.code = code;
        this.color = color;
        this.time = time;
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        String color = sc.next();
        int time = sc.nextInt();
        Boom boom = new Boom(code, color, time);
        System.out.println("code : " + boom.code);
        System.out.println("color : " + boom.color);
        System.out.println("second : " + boom.time);
    }
}