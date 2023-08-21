package ch11;

import java.util.*;

public class ArrayListEx2 {
	/**
	 * ArrayList에 특정길이로 자른 문자열을 담아 저장
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		final int LIMIT = 10;	// 자르고자 하는 글자의 개수
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
		
		List list = new ArrayList(length/LIMIT + 10);
		
		for(int i = 0; i < length; i+=LIMIT) {
			if(i+LIMIT < length)
				list.add(source.substring(i, i + LIMIT));
			else
				list.add(source.substring(i));	// i부터 끝까지
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
