package ch11;

import java.util.*;

public class ArrayListEx1 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);	// 크기 10짜리 만듦
		list1.add(5);
		list1.add(4);
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));	// idx:1~3까지의 갑을 반환하는 메서드
		print(list1, list2);
		
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1, list2);
		
		System.out.println("list1.contatainsAll(list2):"+list1.containsAll(list2));	// true
		System.out.println("list2.contatainsAll(list1):"+list2.containsAll(list1));	// false
		System.out.println();
		
		list2.add("B");
		list2.add("C");
		list2.add("A");
		print(list1, list2);	// list2: [0, 2, 4, B, C, A]
		
		list2.set(3, "AA");
		print(list1, list2);	// list2: [0, 2, 4, AA, C, A]
		
		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제
		System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
		
		// list2에서 list1에 포함된 객체들을 삭제 -> 제어 변수를 감소시키면서 해야 자리이동이 발생해도 영향X
		for(int i = list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))	// list2에 i원소를 얻어서 포함 여부를 파악
				list2.remove(i);	// list2에서 i인덱스에 있는 원소를 지운다.
		}
		print(list1, list2);
	}
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		System.out.println();
	}

}
