import java.util.*;

/**
 * 아름다운 수
 */
public class Problem2t {
    public static int n;
    public static int ans;
    public static ArrayList<Integer> seq = new ArrayList<>();
    
    public static boolean isBeautiful() {
        // 연달아 같은 숫자가 나오는 시작위치
        for(int i = 0; i < n; i += seq.get(i)) {
            // 해당 숫자만큼 나올 수 없다면
            if(i + seq.get(i) - 1 >= n) {
                return false;
            }

            for(int j = i; j < i + seq.get(i); j++) {
                if(seq.get(j) != seq.get(i))
                    return false;
            }
        }
        return true;
    }


    public static void countBeautifulSeq(int cnt) {
        if(cnt == n) {
            if(isBeautiful())
                ans++;
            return;
        }

        for(int i = 1; i <= 4; i++) {
            seq.add(i);
            countBeautifulSeq(cnt + 1);
            seq.remove(seq.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        countBeautifulSeq(0);

        System.out.println(ans);
    }    
}
