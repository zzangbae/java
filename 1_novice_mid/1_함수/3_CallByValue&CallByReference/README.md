# Call By Value, Call By Reference

* JVM 메모리
    * Java에서는 함수에 인자를 넘길 때 기본적으로 값을 복사해서 넘겨줌 -> Call By Value
    * int, char, double과 같은 primitive type의 변수들은 변수와 그 변수에 들어있는 값이 모두 Stack에 저장
    * String, Integer, Array와 같은 reference type의 경우 그 객체(값)는 Heap 영역에 저장, Stack 영역에 있는 변수가 객체의 주소값을 가지고 있음
    * reference type인 변수를 함수의 인자로 넘기게 되면 해당 객체를 가리키는 새로운 변수가 Stack 영역에 정의됨 -> Java는 항상 Call By Value의 원칙을 따름
        * Heap에 정의된 객체를 가리키는, 복사된 변수를 통해서 해당 값을 변경하고
        * 기존의 변수가 Heap에 정의된 객체를 다시 참조할 때, 달라진 값을 확인할 수 있도록한다.
        -> Swap.class를 참고하자.

        