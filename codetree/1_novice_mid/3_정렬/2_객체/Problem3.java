import java.util.Scanner;

class Agent {
    String name;
    int point;
    
    public Agent() {
        this.name = "";
        this.point = 0;
    }

    public Agent(String name, int point) {
        this.name = name;
        this.point = point;
    }
}

// 객체를 원소로 하는 리스트 - 코드네임
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agent[] agents = new Agent[5];
        int minIdx = 0;
        for(int i = 0; i < 5; i++) {
            String name = sc.next();
            int point = sc.nextInt();
            agents[i] = new Agent(name, point);
            // 기존 최저값보다 작다면
            if(point < agents[minIdx].point)
                minIdx = i;
        }
        System.out.println(agents[minIdx].name + " " + agents[minIdx].point);
            
    }
}