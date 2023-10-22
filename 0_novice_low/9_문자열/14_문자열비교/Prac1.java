public class Prac1 {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abe";
        String c = "aba";

        System.out.println(a.compareTo(b)); // -1
        System.out.println(a.compareTo(c)); // 2
        System.out.println(a.compareTo(a)); // 0

        // str1.compareTo(str2)
        // 값이 0보다 작으면 str1이 사전적으로 더 앞서고
        // 값이 0보다 크면 str2가 사전적으로 더 앞선다.
        // 값이 0이면 str1과 str2가 같음을 의미한다.
    }    
}