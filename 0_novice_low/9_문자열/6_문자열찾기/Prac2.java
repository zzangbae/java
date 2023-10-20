public class Prac2 {
    public static void main(String[] args) {
        String s = "appleabanana";
        System.out.println(s.substring(5, 7));
        System.out.println(s.substring(5, 7) == "ab");
        // false -> Java에서 문자열 비교는 ==으로 하면 안됨(이것은 문자열의 주소값이 일치하는 지를 판단한다.)
        
        System.out.println(s.substring(5, 7).equals("ab"));
        // .substring 메서드는 String을 반환한다. 위의 예시에서는 [5, 6(7 -1)] 부분을 반환
        // .equals 메서드를 통해서 문자열이 동일한지 비교할 수 있다.
    }    
}
