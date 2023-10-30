import java.util.*;

/**
 * K중 하나를 N번 선택하기(Simple)
 * n자리 2진수를 모두 재귀함수를 통해 만들기
 */
public class Prac {
    public static int n;
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void print() {
        for(int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }

    public static void choose(int currNum) {
        if(currNum == n + 1) {
            print();
            return;
        }

        answer.add(0);
        choose(currNum + 1);
        answer.remove(answer.size() - 1);

        answer.add(1);
        choose(currNum + 1);
        answer.remove(answer.size() - 1);
    }

    public static void main(String[] args) {
        // 재귀함수 : f라는 함수를 구현하는데, 동일한 f함수가 함수 내부에서 쓰이는 경우
        // 재귀함수 -> 종료조건, 재귀호출로 이루어짐
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        choose(1);
    }
}
