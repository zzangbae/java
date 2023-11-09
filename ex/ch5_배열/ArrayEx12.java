import java.util.*;

/**
 * 참조형 배열 - String[]
 */
public class ArrayEx12 {
    public static void main(String[] args) {
        String[] names = {"Kim", "Park", "Yi"};

        for(int i = 0; i < names.length; i++)
            System.out.printf("names[%d]: %s%n", i, names[i]);

        // 값을 읽어오기
        String tmp = names[2];
        System.out.println("tmp: " + tmp);

        names[0] = "Yu";
        for(String str : names) {
            System.out.println(str);
        }
    }
}
