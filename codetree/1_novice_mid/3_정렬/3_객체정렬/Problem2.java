import java.util.Scanner;
import java.util.Arrays;

class Student implements Comparable<Student> {
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 국어 내림차순 -> 영어 내림차순 -> 수학 내림차순
    @Override
    public int compareTo(Student s) {
        if(this.kor == s.kor) {
            if(this.eng == s.eng)
                return s.math - this.math;
            else
                return s.eng - this.eng;
        }
        return s.kor - this.kor;
    }
}

// 여러기준으로 객체정렬 - 국영수 순이지
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();
            students[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(students);

        for(int i = 0; i < n; i++)
            System.out.println(students[i].name + " " + students[i].kor + " " + students[i].eng + " " + students[i].math);
    }
}