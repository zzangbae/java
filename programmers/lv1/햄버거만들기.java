// 11:03~11:32(29분)
import java.util.ArrayList;

class Solution {
    public static boolean okay(ArrayList<Integer> al) {
        return al.get(al.size() - 1) == 1 && al.get(al.size() - 2) == 3
          && al.get(al.size() - 3) == 2 && al.get(al.size() - 4) == 1;
    }
    
    public int solution(int[] ingredient) {
        int answer = 0;
        // 1: 빵
        // 2: 야채
        // 3: 고기
        // 1-2-3-1 순일때만들어진다.
        // 스택을 이용하는 문제인듯하다. - 단 4개이기 때문에 가변
        int l = ingredient.length;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < l; i++) {
            al.add(ingredient[i]);
            // 길이가 4보다 크고 1231이 존재하면 삭제
            while(al.size() >= 4) {
                // 1231이 끝에 있으면 삭제하고 while문 한번더
                if(okay(al)) {
                    // 맨 뒤에 값 4개 삭제
                    for(int k = 0; k < 4; k++)
                        al.remove(al.size() - 1);
                    answer++;
                } else  // 1231이 끝에 없으면 break
                    break;
            }
        }
        return answer;
    }
}