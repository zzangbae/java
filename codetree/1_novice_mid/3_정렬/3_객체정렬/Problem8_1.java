import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Point {
    int v, num, num2;   // num2는 이동한 자리
    
    public Point(int v, int num) {
        this.v = v;
        this.num = num;
    }
}

// 정렬된 숫자 위치 알아내기 - 수열 오름차순 정렬했을 때, 각각의 위치가 있던 원소의 위치로 이동하는지 파악
public class Problem8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] pts = new Point[n];
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            pts[i] = new Point(a, i + 1);
        }

        // 오름차순 정렬
        Arrays.sort(pts, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return a.v - b.v;
            }
        });
        
        // 지금이동해온 자리를 기록
        for(int i = 0; i < n; i++)
            pts[i].num2 = i + 1;
        
        // 다시 번호순으로 정렬
        Arrays.sort(pts, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return a.num - b.num;
            }
        });

        // 바뀌었던 자리를 출력(num2)
        for(int i = 0; i < n; i++)
            System.out.print(pts[i].num2 + " ");
    }
}