import java.util.*;

/**
 * 1차원 젠가
 */
public class Problem1 {
    public static final int MAX_N = 100;

    public static int n;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] tmp = new int[MAX_N + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        
        int k = 2;
        while(k-- > 0) {
            // tmp 초기화 하기
            for(int i = 1; i <= n; i++)
                tmp[i] = 0;

            int s = sc.nextInt();
            int e = sc.nextInt();
            int tmpIdx = 1;
            
            for(int i = 1; i <= n; i++) {
                // 범위안이면 빼기
                if(i >= s && i <= e)
                    continue;
                tmp[tmpIdx] = arr[i];
                tmpIdx++;
            }
            // tmp를 복사해서 원래 배열에 넣기
            for(int i = 1; i<= n; i++) {
                arr[i] = tmp[i];
            }
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(arr[i] == 0)
                break;
            cnt++;
        }
        System.out.println(cnt);
        for(int i = 1; i <= n; i++) {
            if(arr[i] == 0)
                break;
            System.out.println(arr[i]);
        }
    }
}
