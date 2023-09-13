import java.util.Scanner;
import java.util.ArrayList;

// 동적배열
public class DynamicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 동적배열 선언 및 초기화
        // <T> : T는 reference Type이어야 한다.
        ArrayList<Integer> dynamicArr = new ArrayList<>();
        int n = sc.nextInt();   // 몇 개의 값을 넣을 것인지
        for(int i = 0; i < n; i++)
            dynamicArr.add(sc.nextInt());   // add(n) : n값을 동적배열 맨 끝에 추가

        System.out.println("--동적 배열을 확인--");
        for(int num : dynamicArr)
            System.out.print(num + " ");
        
        System.out.println();
        System.out.println("동적 배열의 크기: " + dynamicArr.size());  // size() : 동적배열의 크기를 찾음
        System.out.println("동적 배열의 첫번째 값: " + dynamicArr.get(0));  // get(index) : index + 1 번째의 값을 조회
        System.out.println("동적 배열의 두번째 값: " + dynamicArr.get(1));  // 만약 해당 인덱스에 값이 없다면 오류(IndexOutOfBoundsException), 있다면 오류나지 않음
        System.out.println("동적 배열의 첫번째 값 삭제: " + dynamicArr.remove(0));  // remove(index) : index + 1 번째값을 반환하고 해당 값 삭제
        
        System.out.println("--삭제 후, 동적 배열을 확인--");
        for(Integer num : dynamicArr)   // 요소 순회할 때, int를 하든, Integer로 하든 상관없이 다 됨
            System.out.print(num + " ");
    }    
}
