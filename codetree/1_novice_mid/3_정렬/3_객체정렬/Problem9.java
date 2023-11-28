import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Student {
    int h, w, num;
    
    public Student(int h, int w, int num) {
        this.h = h;
        this.w = w;
        this.num = num;
    }
}

// 줄 세우기2 -> 키 오름차순, 같다면 몸무게 내림차순 정렬
public class Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] stds = new Student[n];
        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            stds[i] = new Student(h, w, i + 1);
        }

        Arrays.sort(stds, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                // 키가 더 작은 학생이 앞에 -> 오름차순
                if(a.h != b.h)
                    return a.h - b.h;
                // 키 동일 -> 몸무게 큰 학생이 앞 -> 내림차순
                if(a.w != b.w)
                    return b.w - a.w;
                return 1;   // 키와 몸무게가 동일한 경우는 없기 때문에, 그냥 1
                // 사실 아래와 같이 해도 된다.
                // if(a.h != b.h)
                //     return a.h - b.h;
                // return b.w - a.w;

            }
        });

        for(int i = 0; i < n; i++)
            System.out.println(stds[i].h + " " + stds[i].w + " " + stds[i].num);
    }
}