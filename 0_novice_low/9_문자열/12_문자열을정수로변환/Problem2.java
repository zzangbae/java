import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int idx1 = 0;
        int idx2 = 0;
        int aLen = a.length();
        int bLen = b.length();

        for(int i = 0; i < aLen; i++) {
            if(a.charAt(i) < '0' || a.charAt(i) > '9')
                break;
            idx1++;
        }

        for(int i = 0; i < bLen; i++) {
            if(b.charAt(i) < '0' || b.charAt(i) > '9') {
                break;
            }
            idx2++;
        }
        String aStr = a.substring(0, idx1);
        String bStr = b.substring(0, idx2);
        int aInt = Integer.parseInt(aStr);
        int bInt = Integer.parseInt(bStr);

        System.out.println(aInt + bInt);
    }
}
