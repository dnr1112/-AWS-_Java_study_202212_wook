package j07_반복;

public class Star {

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			for(int k = 0; k < 10 - i; k++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j < 2*i + 1; j++) {
				System.out.print("*");
			}
			
			for(int m = 0; m < 10 - i; m++) {
				System.out.print(" ");
			}
			
			System.out.println();
		}
		
		for(int i = 0; i < 10; i++) {
			for(int k = 0; k < i+1; k++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j < 19 - 2*i; j++) {
				System.out.print("*");
			}
			
			for(int m = 0; m < i+1; m++) {
				System.out.print(" ");
			}
			
			System.out.println();
		}
		
	}

}
