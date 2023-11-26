import java.util.Arrays;
import java.util.Collections;

public class Prac1_ArraySort {
    public static void main(String[] args) {
        // 1. 기본 Arrays.sort()활용 -> 기본 오름차순
        int[] arr = new int[]{12, 41, 37, 81, 19, 25, 60, 20};
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        // 12 19 20 25 37 41 60 81 : 전체 오름차순 정렬

        System.out.println("------------");

        // 2. 특정 부분만 적용하기
        int[] arr2 = new int[]{12, 41, 37, 81, 19, 25, 60, 20};
        Arrays.sort(arr2, 0, 3);
        for(int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");
        // 12 37 41 81 19 25 60 20 : 부분 오름차순 정렬

        System.out.println("------------");

        // 3. 내림차순하기
        Integer[] arr3 = new Integer[]{12, 41, 37, 81, 19, 25, 60, 20};
        Arrays.sort(arr3, Collections.reverseOrder());
        for(int i = 0; i < arr3.length; i++)
            System.out.print(arr3[i] + " ");
        // 81 60 41 37 25 20 19 12 : 내림차순

        // 4. 스트림을 활용하여 int[]를 Integer[]로 바꿀 수도 있다.
        int[] arr4 = new int[]{12, 41, 37, 81, 19, 25, 60, 20};
        Integer[] arr5 = Arrays.stream(arr4).boxed().toArray(Integer[]::new);
        Arrays.sort(arr5, Collections.reverseOrder());
        // -> 스트림을 더 학습하고 활용해야할 듯하다.
    }
}

// Java 배열 내 원소 정렬 -> Arrays.sort() : 기본은 오름차순이다.
// Arrays.sort(arr, 시작 index, 끝 index + 1) -> 특정 구간 정렬

// 내림차순
// -> primitive타입으로 구성된 배열을 한번에 내림차순으로 정렬할 수는 없다.
// Collections.reverseOrder() 을 활용한다.
