package j12_배열.di;

public class Test_A {
	
	private final Test_B tb;	// 중간에 setter를 통해서 값이 변하면 안되는 변수는 fianl로 지정
	
//	public Test_A() {			// testA가 생성되어야만 B가 생성됨 = 의존도가 높음
//		tb = new Test_B();
//	}
	
	public Test_A(Test_B tb) {	// 생성자
		this.tb = tb;
	}
	
//	public void setTb(Test_B tb) {
//		this.tb = tb;
//	}
	
	
	public void testA1() {
		System.out.println("테스트A1 메소드 호출!!");
		
//		Test_B tb = new Test_B();
		
		tb.testB1();
		
	}
	
	public void testA2() {
		System.out.println("테스트A2 메소드 호출!!");
//		Test_B tb = new Test_B();
		
		tb.testB1();
	}
	
	
}
