import java.util.Arrays;
import java.util.Collections;

public class Prac3_StringListSort {
    public static void main(String[] args) {
        String[] words = new String[]{"banana", "apple", "cat", "app"};
        Arrays.sort(words);
        for(int i = 0; i < words.length; i++)
            System.out.print(words[i] + " ");
        // app apple banana cat

        System.out.println();
        Arrays.sort(words, Collections.reverseOrder());
        for(int i = 0; i < words.length; i++)
            System.out.print(words[i] + " ");
        // cat banana apple app
    }
}

// 문자열 리스트 정렬
// Arrays.sort()로 간단하게 해결
// String은 참조타입이기 때문에 사전역순도 간단하게 해결할 수 있다.
