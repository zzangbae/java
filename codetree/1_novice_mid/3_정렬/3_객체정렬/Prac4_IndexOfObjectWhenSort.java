import java.util.Arrays;

class Stud implements Comparable<Stud> {
    int kor, eng, math, num;

    public Stud(int kor, int eng, int math, int num) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.num = num;
    }

    @Override   // 국어점수 기준
    public int compareTo(Stud s) {
        return s.kor - this.kor;
    }
}
public class Prac4_IndexOfObjectWhenSort {
    public static void main(String[] args) {
        Stud[] studs = new Stud[]{
            new Stud(90, 80, 90, 1), // 첫 번째 학생
            new Stud(20, 80, 80, 2), // 두 번째 학생
            new Stud(90, 30, 60, 3), // 세 번째 학생
            new Stud(60, 10, 50, 4), // 네 번째 학생
            new Stud(80, 20, 10, 5)  // 다섯 번째 학생
        };

        Arrays.sort(studs);

        for(int i = 0; i < studs.length; i++)
            System.out.println(i + 1 + "등: " + studs[i].num + "번");
    }
}

// 객체 정렬시 index멤버 변수의 필요성
// 만약 1~5등까지 학생의 번호를 요구하는 문제가 있다면
// 멤버변수로 학생의 번호를 설정해두어야 한다.