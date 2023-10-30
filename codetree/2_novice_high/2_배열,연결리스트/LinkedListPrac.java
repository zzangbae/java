import java.util.LinkedList;

// 연결리스트
public class LinkedListPrac {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();

        // addFirst(a) : 연결리스트 맨 앞에 값을 추가
        l.addFirst(3);  // 3
        l.addFirst(2);  // 2 3
        l.addFirst(1);  // 1 2 3
        for(int num : l)
            System.out.print(num + " ");    // 1 2 3
        
        System.out.println();

        // addLast(a) : 연결리스트 맨 뒤 값을 추가
        l.addLast(4);
        l.addLast(5);
        for(int num : l)
            System.out.print(num + " ");
        
        System.out.println();

        // size() : 연결리스트 사이즈 크기
        System.out.println("연결리스트의 크기 : " + l.size());

        // peekFirst(), peekLast() : 연결리스트 맨 앞, 맨 뒷값을 반환
        System.out.println("연결리스트 맨 앞의 값 : " + l.peekFirst());
        System.out.println("연결리스트 맨 뒤의 값 : " + l.peekLast());
        
        // pollFirst(), pollLast() : 연결리스트 맨 앞, 맨 뒷값을 반환 후 리스트에서 제외
        System.out.println("연결리스트 맨 앞의 값을 반환 후 제외 : " + l.pollFirst());
        System.out.println("연결리스트 맨 뒤의 값을 반환 후 제외 : " + l.pollLast());

        System.out.print("삭제 후 리스트 : ");
        for(int num : l)
            System.out.print(num + " ");

        System.out.println();
        System.out.println("연결리스트가 비었는지 : " + l.isEmpty());
        l.pollFirst();
        l.pollFirst();
        l.pollFirst();
        System.out.println("연결리스트가 비었는지 : " + l.isEmpty());
        
    }
}
