import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Student {
    String name;
    int h;
    double w;

    public Student(String name, int h, double w) {
        this.name = name;
        this.h = h;
        this.w = w;
    }
}

// 개인정보 - 이름순으로 오름차순, 키순으로 오름차순
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] stds = new Student[5];
        for(int i = 0; i < 5; i++) {
            String name = sc.next();
            int h = sc.nextInt();
            double w = sc.nextDouble();
            stds[i] = new Student(name, h, w);
        }

        // 이름순 정렬
        System.out.println("name");
        Arrays.sort(stds, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                String s1 = a.name;
                String s2 = b.name;
                return s1.compareTo(s2);
            }
        });

        for(int i = 0; i < 5; i++)
            System.out.printf("%s %d %.1f\n", stds[i].name, stds[i].h, stds[i].w);

        System.out.println();

        // 키순 정리
        System.out.println("height");
        Arrays.sort(stds, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return b.h - a.h;
            }
        });

        for(int i = 0; i < 5; i++)
            System.out.printf("%s %d %.1f\n", stds[i].name, stds[i].h, stds[i].w);
    }
}