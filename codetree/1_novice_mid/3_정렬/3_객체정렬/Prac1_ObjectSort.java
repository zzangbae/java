import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student> {
    int kor, eng, math;

    public Student(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student student) {
        return this.kor - student.kor;  // 오름차순
        // 만약 아래와 같이 쓰면 내림차순
        // return student.kor - this.kor;
    }
}

// 객체 정렬
public class Prac1_ObjectSort {
    public static void main(String[] args) {
        Student[] students = new Student[] {
            new Student(90, 80, 90),
            new Student(20, 80, 80),
            new Student(90, 30, 60),
            new Student(60, 10, 50),
            new Student(80, 20, 10)
        };

        Arrays.sort(students);

        for(int i = 0; i < students.length; i++)
            System.out.println(students[i].kor + " " + students[i].eng + " " + students[i].math);
    
        /** 국어점수 기준 오름차순
         * 20 80 80
         * 60 10 50
         * 80 20 10
         * 90 80 90
         * 90 30 60
         */

        // 아래와 같이 영어 점수에 대해서 수행할 수 있다.(Java8)-람다표현, 단 이미 국어를 기준으로 정렬되어 있는 상태에서 정렬
        Arrays.sort(students, (a, b) -> a.eng - b.eng); // 영어점수 기준 오름차순 정렬
        System.out.println("-----------");
        for(int i = 0; i < students.length; i++)
            System.out.println(students[i].kor + " " + students[i].eng + " " + students[i].math);

        /** 영어점수 기준 오름차순
         * 60 10 50
         * 80 20 10
         * 90 30 60
         * 20 80 80
         * 90 80 90
         */

        // 아래와 같이 Comparator을 활용하여 수행이 가능하기도 하다.
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.math - b.math;
            }
        });
        System.out.println("-----------");
        for(int i = 0; i < students.length; i++)
            System.out.println(students[i].kor + " " + students[i].eng + " " + students[i].math);
        
        /** 수학점수 기준으로 오름차순
         * 80 20 10
         * 60 10 50
         * 90 30 60
         * 20 80 80
         * 90 80 90
         */
    }
}

// 객체정렬
// custom comparator을 만들어주어야 한다.
// Override한 함수의 값에 따라서 정렬
// 양수이면 -> 현재 객체(this)가 정렬 기준 더 뒤에 나오게 된다.
// 음수이면 -> 현재 객체가 정렬 기준 더 앞에 나오게 된다.