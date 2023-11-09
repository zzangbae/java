/**
 * 배열의 활용3-2: 섞기2 - 로또번호 생성예시
 */
public class ArrayEx8 {
    public static void main(String[] args) {
        int[] ball = new int[45];

        for(int i = 0; i < ball.length; i++)
            ball[i] = i + 1;
        
        int tmp = 0;    // 두 값을 바꾸는데 사용할 임시변수
        int j = 0;      // 임의의 값을 얻어서 저장할 변수

        // 0~5번째 요소까지 모두 6개를 임의의 카드의 값과 변경한다.
        for(int i = 0; i < 6; i++) {
            j = (int)(Math.random() * 45);
            tmp = ball[i];
            ball[i] = ball[j];
            ball[j] = tmp;
        }

        for(int i = 0; i < 6; i++) {
            System.out.printf("ball[%d]:%d%n", i, ball[i]);
        }

    }
}
