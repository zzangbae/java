import java.util.Scanner;
import java.util.Arrays;

class Point implements Comparable<Point> {
    int x, y, num;
    public Point(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(Point p) {
        int dis1 = Math.abs(this.x) + Math.abs(this.y);
        int dis2 = Math.abs(p.x) + Math.abs(p.y);
        if(dis1 == dis2)
            return this.num - p.num;
        return dis1 - dis2;
    }
}

// 원점으로부터의 거리 - 원점에서 가까운 점부터 순서대로 출력 - 같을 경우, 번호가 작은 점부터 출력
public class Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y, i + 1);
        }

        Arrays.sort(points);

        for(int i = 0; i < n; i++)
            System.out.println(points[i].num);
    }
}