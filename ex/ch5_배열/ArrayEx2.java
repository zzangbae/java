import java.util.*;

public class ArrayEx2 {
    public static void main(String[] args) {
        int[] iArr1 = new int[10];
        int[] iArr2 = new int[10];
        // int[] iArr3 = new int[]{100, 95, 80, 70, 60};
        int[] iArr3 = {100, 95, 80, 70, 60};    // 이렇게도 배열의 초기화가 가능하다.
        char[] chArr = {'a', 'b', 'c', 'd'};

        for(int i = 0; i < iArr1.length; i++) {
            iArr1[i] = i + 1;   // 1~10숫자를 순서대로 배열에 넣는다.
        }

        for(int i = 0; i < iArr2.length; i++) {
            iArr2[i] = (int)(Math.random() * 10) + 1;   // 1~10의 값을 배열에 저장
            // cf) Math.random()은 0.0과 같거나 크고, 1.0보다 작은 값을 출력한다.
        }

        // 배열에 저장된 값 출력 방법
        // 1. for문을 통해서 출력
        for(int i = 0; i < iArr1.length; i++) {
            System.out.print(iArr1[i] + ",");
        }

        // 2. Arrays.toString(배열 이름)
        System.out.println();
        System.out.println(Arrays.toString(iArr2)); // [4, 2, 9, 1, 4, 5, 8, 2, 10, 5] -> 랜덤한 값
        System.out.println(Arrays.toString(iArr3)); // [100, 95, 80, 70, 60]
        System.out.println(Arrays.toString(chArr)); // [a, b, c, d]
        System.out.println(iArr3);  // 필요없는 값이 나오게 된다. "타입@주소 - 주소도 실제의 주소가 아님"
        System.out.println(chArr);  // abcd 의미있는 값이 출력되게 된다.
    }
}
