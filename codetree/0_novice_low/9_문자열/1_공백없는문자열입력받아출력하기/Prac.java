import java.util.Scanner;

public class Prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // .next() : 공백없는 문자열 받기
        String str = sc.next();
        System.out.println(str);

        // .charAt(index) : 문자열에 담긴 문자 참조
        String str2 = "monkey";
        System.out.println("첫 글자 : " + str2.charAt(0));
        System.out.println("마지막 글자 : " + str2.charAt(str2.length() - 1));
    
        // 문자열의 다른 표현
        char[] cArr = new char[]{'b', 'a', 'n'};
        System.out.println(cArr[0]);    // b
        System.out.println(cArr[1]);    // a
        System.out.println(cArr[2]);    // n

        // .length() : 문자열의 길이
        System.out.println("str2(monkey)의 길아: " + str2.length());
        // 개행문자(\n)은 길이를 1로 친다.
        System.out.println("ZZANGBAE\n".length());  // 9
    }    
}
