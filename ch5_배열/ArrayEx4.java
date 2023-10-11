/**
 * System.arraycopy()를 통한 배열복사
 * -> 배열의 복사는 System.arraycopy()를 통해서 하자
 */
public class ArrayEx4 {
    public static void main(String[] args) {
        char[] abc = {'A', 'B', 'C', 'D'};
        char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        System.out.println(abc);
        System.out.println(num);

        // 배열 abc와 배열 num을 붙여서 하나의 배열(result)로 만들기
        char[] result = new char[abc.length+num.length];
        System.arraycopy(abc, 0, result, 0, abc.length);
        System.arraycopy(num, 0, result, abc.length, num.length);
        System.out.println(result);

        // 배열 abc을 배열 num의 첫번째 위치부터 복사하여 출력
        System.arraycopy(abc, 0, num, 0, abc.length);
        System.out.println(num);

        // num의 인덱스 6위치에 3개를 복사
        System.arraycopy(abc, 0, num, 6, 3);
        System.out.println(num);
    }
}

/**
 * 결과
ABCD
0123456789
ABCD0123456789
ABCD456789
ABCD45ABC9
ABCD0123456789
*/
