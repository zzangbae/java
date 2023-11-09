/**
 * 배열의활용6 : 빈도수 구하기 -> 카운트 정렬
 */
public class ArrayEx11 {
    public static void main(String[] args) {
        int[] numArr = new int[10];
        int[] count = new int[10];

        /// 랜덤으로 값을 넣고
        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = (int)(Math.random() * 10);
        }

        // 카운팅 정렬을 만들고
        for(int i = 0; i < numArr.length; i++) {
            count[numArr[i]]++;
        }

        // 출력
        for(int i = 0; i < count.length; i++) {
            System.out.printf("count[%d]:%d%n", i, count[i]);
        }
    }
}
