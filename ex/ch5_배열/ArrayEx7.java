/**
 * 배열의 활용3: 섞기
 */
public class ArrayEx7 {
    public static void main(String[] args) {
        int[] numArr = new int[10];

        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = i;
            System.out.print(numArr[i]);
        }
        System.out.println();

        for(int i = 0; i < 100; i++) {
            int n = (int)(Math.random() * 10);
            int tmp = numArr[0];
            numArr[0] = numArr[n];
            numArr[n] = tmp;
        }

        // 더 효율적인 섞기
        for(int i = 0; i < numArr.length; i++) {
            int n = (int)(Math.random() * 10);
            int tmp = numArr[i];
            numArr[i] = numArr[n];
            numArr[n] = tmp;
        }

        // 변경 후 출력
        for(int i = 0; i < numArr.length; i++) {
            System.out.print(numArr[i]);
        }
    }
}
