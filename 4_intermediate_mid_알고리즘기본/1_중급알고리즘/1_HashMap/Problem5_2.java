import java.util.*;

public class Problem5_2 {
    public static final int MAX_N = 100000;

    public static int n, k;
    public static long[] arr = new long[MAX_N];
    public static HashMap<Long, Integer> count = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int ans = 0;

        for(int i = 0; i < n; i++) {
            long diff = k - arr[i];
            if(count.containsKey(diff))
                ans += count.get(diff);
            if(!count.containsKey(arr[i]))
                count.put(arr[i], 1);
            else
                count.put(arr[i], count.get(arr[i]) + 1);
        }

        System.out.println(ans);
    }
}
