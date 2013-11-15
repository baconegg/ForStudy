package org.edy.test;

import org.edy.list.ArrayList;
import org.edy.list.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		System.out.println("isEmpty() : " + list.isEmpty());
		
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("라");
		list.add("마");
		list.add("바");

		System.out.println("\n현재 들어 있는 요소 들 : ");
		for(int i = 0, n = list.size(); i < n; i++){
			System.out.println(list.get(i));
		}
		
		list.remove(3);	//4번째 요소 삭제
		
		System.out.println("\n4번째 요소 삭제 후 : ");
		for(int i = 0, n = list.size(); i < n; i++){
			System.out.println(list.get(i));
		}
		
		list.remove("가"); //가 삭제
		
		System.out.println("\n\"가\" 객체 삭제 후 : ");
		for(int i = 0, n = list.size(); i < n; i++){
			System.out.println(list.get(i));
		}
		
		list.add("add");

		System.out.println("\nadd 추가 후 : ");
		for(int i = 0, n = list.size(); i < n; i++){
			System.out.println(list.get(i));
		}
		
		list.add("라", 3);
		
		System.out.println("\n4번째 위치에 \"라\" 추가 후 : ");
		for(int i = 0, n = list.size(); i < n; i++){
			System.out.println(list.get(i));
		}
		
		list.clear();
		
		System.out.println("\nclear 후 isEmpty() : " + list.isEmpty());
	}
	
}
