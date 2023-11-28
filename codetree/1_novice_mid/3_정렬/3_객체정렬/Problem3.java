import java.util.Scanner;
import java.util.Arrays;

class Student implements Comparable<Student> {
    String name;
    int x, y, z;

    public Student(String name, int x, int y, int z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Student s) {
        return (this.x + this.y + this.z) - (s.x + s.y + s.z);
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            students[i] = new Student(name, x, y, z);
        }

        Arrays.sort(students);

        for(int i = 0; i < n; i++)
            System.out.println(students[i].name + " " + students[i].x + " " + students[i].y + " " + students[i].z);
    }
}