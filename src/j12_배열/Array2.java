package j12_배열;

public class Array2 {
	
	public static void printNames(String[] names) {
		for(int i = 0; i < names.length; i++) {
			System.out.println("이름[" + (i + 1) + "]: " + names[i]);
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		String[] names = new String[3];
		
		names[0] = "가가가";
		names[1] = "나나나";
		names[2] = "다다다";
		
		String[] names2 = new String[] {"AAA", "BBB", "CCC"};
		
		String[] names3 = {"ㄱㄱㄱ", "ㄴㄴㄴ", "ㄷㄷㄷ", "ㄹㄹㄹ"};
		
		printNames(names);
		printNames(new String[] {"AAA", "BBB", "CCC"});
		printNames(
		names3);
		
		
	}

}
