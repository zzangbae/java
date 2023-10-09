import java.util.*;

/**
 * K개 중에 1개를 n번 뽑기 -> 중복순열
 */
public class Problem1 {

    public static int k, n; // 1~k개. n번 고르기
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void print() {
        for(int i = 0; i < answer.size(); i++)
            System.out.print(answer.get(i) + " ");
        System.out.println();
    }

    public static void choose(int currNum) {
        // 종료조건
        if(currNum == n + 1) {
            print();
            return;
        }
        
        // 재귀호출
        for(int i = 1; i <= k; i++) {
            answer.add(i);
            choose(currNum + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        choose(1);
    }
}
