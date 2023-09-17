import java.util.*;

/**
 * 숫자 등장 횟수 : 아주 큰 숫자를 Array의 Index로 사용하기
 * n개의 숫자 배열이 주어지고, m번에 걸쳐 특정 숫자가 주어지면 해당 숫자가 수열에 몇 번 나왔는지 출력
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 해쉬맵 : 나타난 수, 몇번 나타났는지
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i  = 0; i < n; i++) {
            int k = sc.nextInt();
            // 이미 있다면 갯수 올려주기
            if(map.containsKey(k)) {
                int c = map.get(k);
                int nc = c + 1;
                map.put(k, nc); // 1개 늘린값을 넣어주기(수정)
            } else {
                map.put(k, 1);
            }
        }
        for(int i = 0; i < m; i++) {
            int k = sc.nextInt();
            if(map.containsKey(k))
                System.out.print(map.get(k) + " ");
            else
                System.out.print(0 + " ");
        }
    }
}
