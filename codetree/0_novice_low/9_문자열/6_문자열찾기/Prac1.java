// 문자열 찾기: 특정 문자열 포함 여부
public class Prac1 {
    public static void main(String[] args) {
        String s = "appleabanana";
        int length = s.length();
        boolean exists = false;

        for(int i = 0; i < length - 1; i++) {
            if(s.charAt(i) == 'a' && s.charAt(i + 1) == 'b')
                exists = true;
        }

        if(exists)
            System.out.println("true");
        else
            System.out.println("false");

        // for문과 equals로 판단해보자
        boolean ex1 = false;
        for(int i = 0; i < length - 1; i++) {
            if(s.substring(i, i + 2).equals("ab"))
                ex1 = true;
        }
        if(ex1)
            System.out.println("ex1 true");
        else
            System.out.println("ex1 false");

        // contains메서드를 통해서 포함여부를 간단하게 확인할 수 있다.
        boolean ex2 = false;
        if(s.contains("ab")) {
            ex2 = true;
        }

        if(ex2)
            System.out.println("ex2 true");
        else
            System.out.println("ex2 false");

        
    }    
}
