package j03_형변환;

public class Casting2 {

	public static void main(String[] args) {
		char char_a = 'a';
		int num = (int) char_a;      // char인 변수를 int로 형변환 하라
		
		char char_b = (char) (num + 1);
		
		System.out.println('a' + 1);
		System.out.println(char_b);

	}

}
