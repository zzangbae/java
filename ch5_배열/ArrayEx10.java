import java.util.*;
/**
 * 배열의 활용5: 정렬(버블 정렬)
 */
public class ArrayEx10 {
    public static void main(String[] args) {
        int numArr[] = new int[10];
        
        // 값 넣어주기
        for(int i = 0; i < numArr.length; i++) {
            System.out.print(numArr[i] = (int)(Math.random() * 10));    // 0~9값중 임의로 들어간다.
        }
        System.out.println();

        for(int i = 0; i < numArr.length - 1; i++) {
            boolean changed = false;
            for(int j = 0; j < numArr.length - 1 - i; j++) {
                if(numArr[j] > numArr[j + 1]) {
                    int tmp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1]= tmp;
                    changed = true;
                }
            }
            if(!changed)
                break;  // 변화가 없었던 종료

            System.out.println(Arrays.toString(numArr));    // 정렬된 결과 출력
        }
    }
}
