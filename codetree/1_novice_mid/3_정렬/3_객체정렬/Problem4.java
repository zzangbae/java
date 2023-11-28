import java.util.Scanner;
import java.util.Arrays;

class Student implements Comparable<Student> {
    int h, w, num;

    public Student(int h, int w, int num) {
        this.h = h;
        this.w = w;
        this.num = num;
    }

    @Override
    public int compareTo(Student s) {
        if(this.h == s.h) {
            if(this.w == s.w)
                return this.num - s.num;
            return s.w - this.w;
        } else
            return s.h - this.h;
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            students[i] = new Student(h, w, i + 1);
        }
        
        Arrays.sort(students);

        for(int i = 0; i < n; i++)
            System.out.println(students[i].h + " " + students[i].w + " " + students[i].num);
    }
}