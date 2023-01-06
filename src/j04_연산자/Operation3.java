package j04_연산자;

/*
 * 논리 연산자
 * 
 * AND (곱) T && T, T && F
 * 조건 중 하나라도 F면 0
 * OR (합) T || F
 * 
 * NOT (부정) !T
 */


public class Operation3 {

	public static void main(String[] args) {
		int num = 11;
		
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = num % 2 == 0;
		
		System.out.println(flag1 && flag2);
		System.out.println(flag1 && flag3);
		System.out.println(!(flag2 || flag3 && flag1));

	}

}
