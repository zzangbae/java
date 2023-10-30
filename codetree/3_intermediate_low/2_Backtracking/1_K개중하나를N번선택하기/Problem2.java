import java.util.*;

/**
 * 아름다운 수
 * 17:10~17:29(19분)
 */
public class Problem2 {
    public static int n;    // 1~10
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int result = 0;   // 아름다운 수의 갯수

    // 아름다운 수인지 판단
    public static boolean isBeautifulNum() {
        int checkNum = arr.get(0);
        int now = 0;
        int cnt = 1;
        for(int i = 1; i < arr.size(); i++) {
            now = arr.get(i);
            // 이전의 체크번호와 지금 번호가 같다면 cnt++
            if(checkNum == now) {
                cnt++;
                // 만약 cnt가 checkNum보다 커버렸다면 1로 다시 만들기 222 -> 1
                if(cnt > checkNum) {
                    cnt = 1;
                }
            }
            // 이전의 체크번호와 지금 번호가 다르다면
            else {
                // 아름다운 갯수가 아니라면
                if(cnt != checkNum)
                    return false;
                // 아름다운 갯수가 되었다면 체크번호 바꿔주기
                checkNum = now;
                cnt = 1;    // cnt초기화
            }
        }
        // 나왔을 때 한번 더 체크
        if(cnt != checkNum)
            return false;
        return true;
    }

    // 중복수열만들기(재귀적으로)
    public static void makePermutation(int currNum) {
        // 종료조건
        if(currNum == n + 1) {
            if(isBeautifulNum()) {
                result++;
            }
            return;
        }
        // 재귀호출
        for(int i = 1; i <= 4; i++) {
            arr.add(i);
            makePermutation(currNum + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        // 1이상 4이하의 수가 있음
        // 정확히 해당 숫자만큼 연달아 같은 숫자가 나오면 아름다운 수
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        makePermutation(1);

        System.out.println(result);
    }
}
