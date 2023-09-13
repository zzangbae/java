import java.util.Scanner;

// 정적배열
public class StaticArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정적배열 선언 및 초기화
        int staticArr[] = new int[5];
        for(int i = 0; i < 5; i++)
            staticArr[i] = sc.nextInt();
        
        for(int num : staticArr)
            System.out.print(num + " ");
    }    
}
