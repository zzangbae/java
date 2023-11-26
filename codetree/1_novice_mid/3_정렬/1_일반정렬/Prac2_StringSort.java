import java.util.Arrays;
import java.util.Collections;

public class Prac2_StringSort {
    public static void main(String[] args) {
        String str = "badc";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortedStr = new String(chars);
        System.out.println(sortedStr);  // abcd

        // 만약 내림차순하고 싶다면? -> 사전역순
        String str2 = "zcbda";
        Character[] chars2 = new Character[str2.length()];
        for(int i = 0; i < str2.length(); i++)
            chars2[i] = str2.charAt(i);

        Arrays.sort(chars2, Collections.reverseOrder());
        // -> char이 아니라, Character로 만들어소 new String으로 바로 안만들어짐
        // 따라서 아래와 같이 사용
        String sortedStr2 = "";
        for(int i = 0; i < chars2.length; i++)
            sortedStr2 += chars2[i];
        System.out.println(sortedStr2); // zdcba
    }
}

// String은 char[]과는 다른 개념이다.
// 따라서 str.toCharArray() 메서드를 활용하여 char[]로 바꾸고
// Arrays.sort()를 활용한 뒤
// new String(char [])로 다시 String으로 바꿔서 활용한다.