import java.util.*;

class Pair {
    int s, e;   // 시작점, 끝점
    public Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

class Man {
    int l, p;
    public Man(int l, int p) {
        this.l = l; // 가로위치(라인수)
        this.p = p; // 세로위치
    }
}

/**
 * 사다리 타기
 * 13:03~15:27(2시간 24분)
 * 챗 쥐피티 도움받음 - 동적배열의 배열 만드는데
 */
public class Problem5 {
    public static final int MAX_N = 11;
    public static final int MAX_M = 15;

    public static int n, m; // n : 사람수 및 세로줄 수, m : 가로줄 수
    public static Man[] mans = new Man[MAX_N + 1];  // 인덱스 : 사람번호
    public static Man[] manTmp = new Man[MAX_N + 1];    // man복사해서 둘 곳
    public static ArrayList<Pair>[] arr = new ArrayList[MAX_M + 1];
    public static Pair[] lineList = new Pair[MAX_M];    // 초기에 받는 라인들의 정보
    public static ArrayList<Pair>[] selectedArr = new ArrayList[MAX_M + 1];
    public static int[] standard = new int[MAX_N + 1];  // 사다리 제거 전, 결과
    public static int[] tmpS = new int[MAX_N + 1];

    public static int result = 15;  // 최댓값   -> intMax로 하는 방법 다시보기

    public static void original() {
        // mans를 manTmp에 복사
        for(int i = 1; i <= n; i++) {
            manTmp[i] = new Man(mans[i].l, mans[i].p);
        }
        
        // 사람을 하나씩 사다리에 내려보내기
        for(int i = 1; i <= n; i++) {
            Man nowMan = manTmp[i];
            int l = nowMan.l;
            int p = nowMan.p;
            l++;
            while(l != MAX_M + 1) {
                ArrayList<Pair> a = arr[l];
                // line별 상황 파악
                for(int j = 0; j < a.size(); j++) {
                    // 해당 라인에 l이 맞는 것이 있다면
                    if(p == a.get(j).s) {
                        p = a.get(j).e;  // 점을 이동
                        manTmp[i].p = a.get(j).e;
                        break;
                    }
                }
                l++;    // 다음라인으로 이동    
            }
        }

        // 결과를 스탠다드에 저장
        for(int i = 1; i <= n; i++) {
            standard[i] = manTmp[i].p;
        }
    }

    // selectedArr을 통해서 만든 사다리로 나온 결과와 기존의 결과가 동일한지 판단
    public static boolean sameResult() {
        for(int i = 1; i <= n; i++) {
            manTmp[i] = new Man(mans[i].l, mans[i].p);
            tmpS[i] = 0;    // 초기화
        }

        for(int i = 1; i <= n; i++) {
            Man nowMan = manTmp[i];
            int l = nowMan.l;
            int p = nowMan.p;
            l++;
            while(l != MAX_M + 1) {
                ArrayList<Pair> a = selectedArr[l];
                for(int j = 0; j < a.size(); j++) {
                    if(p == a.get(j).s) {
                        p = a.get(j).e;
                        manTmp[i].p = a.get(j).e;
                        break;
                    }
                }
                l++;
            }
        }

        for(int i = 1; i <= n; i++) {
            tmpS[i] = manTmp[i].p;
        }

        for(int i = 1; i <= n; i++) {
            if(standard[i] != tmpS[i]) {
                return false;
            }
        }
        return true;
    }

    // selectedArr로부터 몇 개의 라인이 선택되었는지 갯수를 세기
    public static int calc() {
        int cnt = 0;
        for(int i = 1; i <= MAX_M; i++) {
            for(int j = 0; j < selectedArr[i].size(); j++) {
                cnt++;
            }
        }
        return cnt / 2;
    }

    // cnt : cnt번째 라인 선택 상황
    public static void choice(int cnt) {
        // 종료조건
        if(cnt == m) {
            // 결과가 기존의 결과와 동일한지를 판단
            if(sameResult()) {
                result = Math.min(result, calc());
            }
            return;
        }
        // lineList로부터 정보받아서 넣고
        Pair selectedPair = lineList[cnt];
        // (1, 1), (1, 3) p의 정보가 나옴 - 세로줄, 라인정보
        int a = selectedPair.s;
        int b = selectedPair.e;
        selectedArr[b].add(new Pair(a, a + 1));
        selectedArr[b].add(new Pair(a + 1, a));
        choice(cnt + 1);
        // 정보 빼기
        selectedArr[b].remove(selectedArr[b].size() - 1);
        selectedArr[b].remove(selectedArr[b].size() - 1);
        // 다시 재귀호출
        choice(cnt + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // 2~11
        m = sc.nextInt();   // 1~15

        for(int i = 1; i <= MAX_N; i++) {
            mans[i] = new Man(0, i);    // 시작 라인은 0
        }

        // 초기화
        for(int i = 1; i <= MAX_M; i++) {
            arr[i] = new ArrayList<Pair>();
            selectedArr[i] = new ArrayList<Pair>(); 
        }


        // 처음 결과와 동일한 결과를 엇기 위해 필요한 최소 가로줄 수 -> 선택
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();   // 시작 세로
            int b = sc.nextInt();   // 라인
            Pair p1 = new Pair(a, a + 1);
            Pair p2 = new Pair(a + 1, a);
            arr[b].add(p1);
            arr[b].add(p2); // 양방향성
            lineList[i] = new Pair(a, b);
        }

        // 먼저 다 있을 때의 결과를 찾는 함수를 돌리자
        original();

        // 백트래킹으로 하나씩 제외해보자
        choice(0);

        System.out.println(result);
    }
}

/**
 * 오래걸린 이유 : 객체복사, 경계 조건(2, 1 최소에서 문제발생)
 */
