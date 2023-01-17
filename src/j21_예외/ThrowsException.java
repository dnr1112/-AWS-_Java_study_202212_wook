package j21_예외;

import java.util.Arrays;
import java.util.List;

public class ThrowsException {
	
	public static void printList(List<String> list, int size) throws Exception{
		
		for(int i = 0; i < size; i++) {
			System.out.println("[" + i + "]" + list.get(i));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		String[] names = {"가가가", "나나나", "다다다", "라라라"};
		
		try {
			printList(Arrays.asList(names), 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("무조건 실행");
		}
		
		System.out.println("프로그램 정상 종료");
		
		
	}

}
