package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetStringMain {

	public static void main(String[] args) {
		
		Set<String> setStr = new HashSet<>();
		List<String> listStr = new ArrayList<>();
		
		listStr.add("AAA");
		listStr.add("BBB");
		listStr.add("BBB");
		listStr.add("BBB");
		
		System.out.println(listStr);
		
		setStr.add("가가가");
		setStr.add("나나나");
		setStr.add("다다다");
		setStr.add("라라라");
		setStr.add("라라라");
		setStr.addAll(listStr);		// set의 특징 상 listStr을 추가해줘도 중복된 값은 하나만 들어감
		
		System.out.println(setStr);
		
		String searchName = "가가가";
		
		for(String name : setStr) {
			if(name.equals(searchName)) {
			System.out.println(name);
			}
		}
		
		Iterator<String> iterator = setStr.iterator();
		while(iterator.hasNext()) {
			String n = iterator.next();
			if(n.equals(searchName)) {
				System.out.println(n);
			}
		}
		
		
		
		
	}

}
