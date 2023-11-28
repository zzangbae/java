import java.util.Arrays;

class Student implements Comparable<Student> {
    int kor, eng, math;

    public Student(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 국어점수 기준으로 오름차순, 같다면 영어점수 기준 내림차순
    @Override
    public int compareTo(Student s) {
        if(this.kor == s.kor)
            return s.eng - this.eng;    // 양수가 나오면 현재값(this)가 뒤로감 -> 내림차순
        else
            return this.kor - s.kor;    // 국어점수 오름차순
    }
}

public class Prac2_ObjectSort {
    public static void main(String[] args) {
        Student[] students = new Student[]{
            new Student(90, 80, 90),
            new Student(20, 80, 80),
            new Student(90, 30, 60),
            new Student(60, 10, 50),
            new Student(80, 20, 10)
        };

        Arrays.sort(students);

        for(int i = 0; i < students.length; i++)
            System.out.println(students[i].kor + " " + students[i].eng + " " + students[i].math);
    }
}

// 앞선 객체정렬에선 하나의 기준으로 ObjectSort하는 방법을 알아보았다.
// 여러 우선순위를 갖는 정렬은 어떻게 하는지 알아보겠다.
