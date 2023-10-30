import java.util.*;

public class Ascend {
    // 들어오는 숫자가 오름차순인지를 확인하는 함수
    public static int isAscend(int x) {
        int last = 10;
        while(x > 0) {
            if(x % 10 > last) return 0; // 현재의 마지막 자릿수가 이전의 마지막 잘릿수보다 크다면 -> 오름차순이 아님!
            last = x % 10;
            x /= 10;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(isAscend(x));
        System.out.println(isAscend(654321) + isAscend(123345) + isAscend(442211) + isAscend(202104));
    }    
}
