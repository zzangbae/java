/**
 * for문을 통한 배열 복사
 */
public class ArrayEx3 {
    public static void main(String[] args) {
        int[] arr = new int[5];

        // 1~5를 arr에 저장
        for(int i = 0; i < arr.length; i++)
            arr[i] = i + 1;

        System.out.println("[변경전]");
        System.out.println("arr.length: " + arr.length);
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]:%d%n", i, arr[i]);
        }

        int[] tmp = new int[arr.length * 2];

        // arr의 값을 tmp에 복사
        for(int i = 0; i < arr.length; i++)
            tmp[i] = arr[i];
        
        // arr가 가리키는 곳을 tmp가 가리키는 배열로 바꿈(arr가 기존에 가리키던 배열은 JVM이 해제시킴)
        arr = tmp;
        
        System.out.println("[변경후]");
        System.out.println("arr.length: " + arr.length);
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]:%d%n", i, arr[i]);
        }
    }    
}
