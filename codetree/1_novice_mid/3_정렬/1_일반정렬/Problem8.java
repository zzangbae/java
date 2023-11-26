import java.util.Scanner;
import java.util.Arrays;

// K번째로 신기한 문자열
// 단어 n개가 주어졌을 때, 문자열 T로 시작하는 단어들 중 사전순으로 정렬했을 때의 k번째 문자열
public class Problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt() - 1;
        String T = sc.next();
        int tl = T.length();
        String[] words = new String[n];
        
        int cnt = 0;    // T로 시작하는 단어의 갯수
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            // 만약 T의 길이가 더 길다면 X
            if(tl > s.length())
                continue;
            if(s.substring(0, tl).equals(T))
                words[cnt++] = s;
        }

        Arrays.sort(words, 0, cnt); // cnt앞까지 sort
        System.out.println(words[k]);
    }
}

// 실수한 부분 -> contains를 쓰면 포함되는 것! 시작이 아니라!