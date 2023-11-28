import java.util.Scanner;
import java.util.Arrays;

// 클래스 선언: 
class Number implements Comparable<Number> {
    int number;
    int index;

    public Number(int number, int index) {
        this.number = number;
        this.index = index;
    }

    @Override
    public int compareTo(Number b) {
        // number가 작으면 정렬 했을 때 앞에 와야 합니다.
        if(number != b.number)
            return number - b.number;
        // index가 작으면 정렬 했을 때 앞에 와야 합니다.
        return index - b.index;
    }
};

public class Problem8_2 {
    public static final int MAX_NUM = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언:
        int n, numCache;
        int[] answer = new int[MAX_NUM];

        Number[] numbers = new Number[MAX_NUM];

        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            numCache = sc.nextInt();
            numbers[i] = new Number(numCache, i);
        }

        // Custom Comparator를 활용한 정렬:
        Arrays.sort(numbers, 0, n);

        // 정렬된 숫자들의 원래 인덱스를 활용한 정답 배열 저장:
        for(int i = 0; i < n; i++) 
            answer[numbers[i].index] = i + 1; // 인덱스 보정

        // 출력:
        for(int i = 0; i < n; i++){
            System.out.print(answer[i] + " ");
        }
    }
}

// 이렇게 answer[] 배열을 활용해서 풀 수도 있음