public class Prac4 {

    public static int findId(String s) {
        String tmp = "";
        for(int i = 3; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ')
                break;
            tmp += c;
        }
        int result = Integer.parseInt(tmp);
        return result;
    }

    public static String findAc(String s) {
        String tmp = "";
        int idx = 0;
        for(int i = 0; i < s.length(); i++) {
            idx++;
            if(s.charAt(i) == ' ')
                break;
        }
        // idx는 action이 시작하는 곳이다.
        for(int i = idx; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ')
                break;
            tmp += c;
        }
        return tmp;
    }

    public static long findK(String s) {
        int cnt = 0;
        int idx = 0;
        int sLen = s.length();
        for(int i = 0; i < sLen; i++) {
            idx++;
            // 공백 개수 찾기
            if(s.charAt(i) == ' ')
                cnt++;
            if(cnt == 2)
                break;
        }
        // idx는 k의 인덱스이다. 따라서 + 2
        String reStr = "";
        for(int i = idx + 2; i < s.length(); i++) {
            reStr += s.charAt(i);
        }
        
        return Long.parseLong(reStr);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"id=1 sit k=5", "id=2 sit k=3", "id=1 leave"};
        for(String str : strs) {
            int id = findId(str);
            String ac = findAc(str);
            if(ac.equals("sit")) {
                long k = findK(str);
                System.out.println("id: " + id + ", ac: " + ac + ", k: " + k);
            }
            else
                System.out.println("id: " + id + ", ac: " + ac);
        }
    }    
}
