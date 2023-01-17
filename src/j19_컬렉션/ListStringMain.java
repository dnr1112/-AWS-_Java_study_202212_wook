package j19_컬렉션;

import java.util.ArrayList;

public class ListStringMain {

	public static void main(String[] args) {
		String[] strArray = new String[]{"java", "python", "C++"};
		
		String[] newStrArray = new String[strArray.length + 1];
		
		for(int i = 0; i < strArray.length; i++) {
			newStrArray[i] = strArray[i];
		}
		
		newStrArray[strArray.length] = "html";
		
		System.out.println("[strArray]");
		for(String str : strArray) {
			System.out.println(str);
		}
		System.out.println();
		
		System.out.println("[newStrArray]");
		for(String str : newStrArray) {
			System.out.println(str);
		}
		System.out.println();
		
		ArrayList<String> strList = new ArrayList<>();
		strList.add("java");
		strList.add("python");
		strList.add("C++");
		strList.add("html");
		
		for(int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
//////////////////////////////////////////////////////////////////////////////////////////
		
//		new ArrayList<String>().add("test"); 얘만 쓰려면 <>안에 자료형을 적어줘야함
//		ArrayList<String> strList = new ArrayList<>();
//		strList.add("java");
//		strList.add("python");
//		strList.add("python");
//		strList.add("python");
//		strList.remove("java");		// 선택한 객체가 사라짐, remove시키는 것에 따라 길이도 유동적으로 변함
//		strList.add(1, "java");		// 1번 index에 java를 넣겠다
//		strList.remove(1);
//		
////		ArrayList<?> strList = new ArrayList<>();
////		((ArrayList<String>)strList).add("java");		// 다운캐스팅 해줘야함
//		
//		for(int i = 0; i < strList.size(); i++) {			// 배열과 다르게 컬렉션은 객체임
//			System.out.print("[" + i + "]");
//			System.out.println(strList.get(i));
//		}
//		System.out.println();
//		
//		for(String str : strList) {
//			System.out.println(str);
//		}
		
	}

}
