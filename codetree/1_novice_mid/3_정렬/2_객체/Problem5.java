import java.util.Scanner;

class Product {
    String name;
    int code;

    public Product() {
        this.name = "codetree";
        this.code = 50;
    }

    public Product(String name, int code) {
        this.name = name;
        this.code = code;
    }
}

// 객체 - 상품코드
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product p = new Product();
        System.out.println("product " + p.code + " is " + p.name);
        // 객체 속성 변경
        p.name = sc.next();
        p.code = sc.nextInt();
        System.out.println("product " + p.code + " is " + p.name);
    }
}