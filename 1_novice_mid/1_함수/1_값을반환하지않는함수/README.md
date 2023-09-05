# 함수 - 값을 반환하지 않는 함수

* 함수는 특정 기능 하나를 위해 코드를 모듈화한 것
* Java의 경우, main함수가 static으로 정의됨 => 함수 또한 static을 써주자(알고리즘 풀이시)
* 함수 명은 camelCase를 활용한다.
* 입력값은 import java.util.Scanner을 통해서 Scanner를 가져온다.
    * 이후, Scanner sc = new Scanner(System.in)으로 값을 받음
    * int a = sc.nextInt(); 이렇게 변수에 입력값을 저장함
* 함수의 인자 넣기 -> 1개, 여러개 가능.
    * 단 호출시, 호출하고자하는 함수의 인자의 갯수와 자료형, 순서를 맞춰야한다.

* GCD(Greatest Common Divisor) : 최대 공약수
    * 1부터 두 수중 작은 값까지 for문을 돌면서
    * 두 수가 해당 값으로 나눴을 때, 둘 다 나머지가 없는 경우 gcd를 갱신
    * for문 돈 이후에 gcd를 출력하면 최대 공약수를 출력할 수 있음

* LCM(Least Common Mulitiple) : 최소 공배수
    * 먼저 GCD를 구한다
    * 두 수의 곱을 GCD로 나누면 LCM을 구할 수 있다.
    * 다른 방법
      * Math.min(n, m)을 통해 두 수 중 작은수부터 숫자를 하나씩 올리면서 LCM을 구한후 반복문 탈출
      * 하지만, 두 수의 차이가 많이 크다면, 오래걸릴 수 있다.