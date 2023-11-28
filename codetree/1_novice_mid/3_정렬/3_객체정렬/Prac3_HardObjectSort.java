import java.util.Arrays;

class Stu implements Comparable<Stu> {
    int kor, eng, math;

    public Stu(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 총합으로 객체 정렬
    @Override
    public int compareTo(Stu s) {
        return (this.kor + this.eng + this.math) - (s.kor + s.eng + s.math);
    }
}

public class Prac3_HardObjectSort {
    public static void main(String[] args) {
        Stu[] students = new Stu[]{
            new Stu(90, 80, 90), // 첫 번째 학생
            new Stu(20, 80, 80), // 두 번째 학생
            new Stu(90, 30, 60), // 세 번째 학생
            new Stu(60, 10, 50), // 네 번째 학생
            new Stu(80, 20, 10)  // 다섯 번째 학생 
        };

        Arrays.sort(students);

        for(int i = 0; i < students.length; i++)
            System.out.println(students[i].kor + " " + students[i].eng + " " + students[i].math + " " + (students[i].kor + students[i].eng + students[i].math)); 
        /** -> 이렇게 나오는 것이 맞다. vs코드의 캐시가 문제인듯? -> 다른 곳에서 override된듯
        80 20 10 110
        60 10 50 120
        20 80 80 180
        90 30 60 180
        90 80 90 260
         */    
    }
}

// 정렬 기준이 복잡한 객체 정렬
// 만약 학생의 국어, 영어, 수학 점수의 총합으로 정렬을 하려고한다면?
// 위와 같이 표현하면 된다.