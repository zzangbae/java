import java.util.LinkedList;
import java.util.ListIterator;


public class IteratorPrac {
    public static void main(String[] args) {
        LinkedList<Character> l = new LinkedList<>();
        l.add('a');
        l.add('b');
        l.add('c');

        ListIterator<Character> it = l.listIterator();

        while(it.hasNext())
            System.out.print(it.next());

        System.out.println();

        int[] fixed_arr = new int[100];
        // int[] dynamic_arr = new int[]; -> 에러남. 크 정해줘야함
    }
}