
// 만약 판단하고자 하는 부분문자열이 input으로 주어진다면?(임의의 길이)
public class Prac3 {
    public static void main(String[] args) {
        String s = "appleabanana";
        String t = "abbaba";

        int n = s.length();
        boolean exists = false;

        int lenT = t.length();

        for(int i = 0; i < n - lenT + 1; i++) {
            boolean allSame = true;
            for(int j = 0; j < lenT; j++) {
                if(s.charAt(i + j) != t.charAt(j)) {
                    allSame = false;
                }
            }

            if(allSame)
                exists = true;
        }

        if(exists)
            System.out.println("true");
        else
            System.out.println("false");
    }    
}
