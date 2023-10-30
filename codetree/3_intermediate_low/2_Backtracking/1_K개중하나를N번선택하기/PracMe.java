import java.util.*;

/**
 * n자리 2진수를 모두 만들고 출력하는 연습
 */
public class PracMe {
    public static int n;
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void print() {
        for(int i = 0; i < answer.size(); i++)
            System.out.print(answer.get(i) + " ");
        System.out.println();
    }

    // currNum번째 수를 정하는 함수
    public static void choose(int currNum) {
        // 종료조건
        if(currNum == n + 1) {
            print();
            return;
        }

        // 재귀호출
        answer.add(0);
        choose(currNum + 1);
        answer.remove(answer.size() - 1);   // 맨 마지막 값을 다시 빼기

        answer.add(1);
        choose(currNum + 1);
        answer.remove(answer.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        choose(1);    
    }
}
