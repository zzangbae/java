import java.util.*;
/**
 * 배열의활용4 : 임의의 값으로 배열 채우기
 */
public class ArrayEx9 {
    public static void main(String[] args) {
        // 랜덤이용해서 값을 채우기는 쉽다.
        // 불연속적인 범위의 값들로 배열을 채우는 것은?
        // 먼저 code배열에 불연속적인 값을 담기
        int[] code = {-4, -1, 3, 6, 11};
        int[] arr = new int[10];

        for(int i = 0; i < arr.length; i++) {
            int n = (int)(Math.random() * code.length); // 인덱스가 설정됨
            arr[i] = code[n];
        }
        System.out.println(Arrays.toString(arr));
    }
}
