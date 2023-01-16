package j19_컬렉션;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapStringMain {

	public static void main(String[] args) {
		Map<String, String> strMap = new HashMap<>();
		
		strMap.put("라라라", "a");		// 순서는 key값의 해시코드에 대한 순서로 나옴
		strMap.put("마마마", "b");
		strMap.put("하하하", "c");
		strMap.put("가가가", "d");
		
		System.out.println(strMap);
		
		System.out.println(strMap.get("a"));
		System.out.println(strMap.get("e"));
		
		for(String k : strMap.keySet()) {
			System.out.println("key: " + k);
			System.out.println(strMap.get(k));
		}
		
		for(String v : strMap.values()) {
			System.out.println("value: " + v);
		}
		
		for(Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry);
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
			System.out.println();
		}
		
		System.out.println("================================");
		strMap.forEach((k, v) -> {
			System.out.println("key: " + k);
			System.out.println("value: " + v);
		});
	}

}
