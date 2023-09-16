import java.util.*;

/**
 * 1차원배열 선언
 */
public class OneDArray {
    public static void main(String[] args) {

        // 배열 생성1 : 크기를 설정하기
        int[] arr1 = new int[3];
        // 딱히 무슨 값을 넣지 않는 상태 -> 0 0 0 이 출력됨(기본값)
        for(int i = 0; i < 3; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.println();

        // 값을 넣어보자
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;

        // 값을 넣은 상태 -> 1 2 3 이 출력됨
        for(int i = 0; i < 3; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.println();

        // 배열 생성2 : 배열 때려박기 -> 배열의 크기값을 적지 않아야함"문법오류"
        int[] arr2 = new int[]{4, 5, 6};
        for(int i = 0; i < 3; i++) {
            System.out.print(arr2[i] + " ");
        }

        // 배열생성 3 : 배열 생성 후, 입력으로 값을 넣기
        Scanner sc = new Scanner(System.in);
        int[] arr3 = new int[3];
        for(int i = 0; i < 3; i++) {
            arr3[i] = sc.nextInt(); // nextInt() 메서드 활용
        }

        // 입력한 값이 나오게 된다
        for(int i = 0; i < 3; i++) {
            System.out.print(arr3[i] + " ");
        }
        
        System.out.println();
        // 만약 특정값을 수정하고 싶다면 아래와 같이 하면 된다.
        // 3번째 값을 100으로 바꾸기
        arr3[2] = 100;
        for(int i = 0; i < 3; i++) {
            System.out.print(arr3[i] + " ");
        }
        
    }
}