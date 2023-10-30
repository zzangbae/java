public class PrintStars1 {
    
    public static void print10Stars() {
        for(int i = 0; i < 10; i++)
            System.out.print("*");
        System.out.println();
    }
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            print10Stars();
    }
}
/** 기본개념 - 함수정의하기
 * 함수 : 하나의 목적을 위해서 모듈화시킨 것
 * Java의 기본골격이 static으로 정의되어 있기 때문에 static으로 함수를 정의해줘야함
 * 함수의 이름의 경우 camelCase를 사용함
 */