package j12_배열;

public class Array6 {
	
	public static void main(String[] args) {
		
		String[] names = {"가가가", "나나나", "다다다"};
		
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
			names[i] = "마마마";
		}
		
		System.out.println("========<forEach>========");
		
		for(String name : names) {		// forEach가 가져오는건 주소값
			System.out.println(name);
			name = "라라라";
		}
		
		int[] nums = {1, 2, 3, 4, 5};
		
		for(int i : nums) {
			System.out.println("i: " + i);
		}
		
		
	}
	
}
