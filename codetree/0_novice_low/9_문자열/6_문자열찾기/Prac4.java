// 특정 문자열이 포함된 위치 : .indexOf()
public class Prac4 {
    public static void main(String[] args) {
        String s = "appleabanana";
        int length = s.length();
        int startIdx = -1;

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == 'a' && s.charAt(i + 1) == 'b') {
                startIdx = i;
                break;
            }
        }

        System.out.println(startIdx);
        
        // 위의 로직이 구현된 것이 아래의 indexOf()메서드 이다.
        System.out.println(s.indexOf("ab"));
    }
}
