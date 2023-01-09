package j12_배열.di;

public class Main {

	public static void main(String[] args) {
		Test_C tc = new Test_C();
		Test_C tc2 = new Test_C();
		
		Test_B tb = new Test_B(tc);
		
		Test_A ta = new Test_A(tb);
		
//		ta.setTb(tb);		// setter를 통한 객체주입방식
		
		ta.testA1();		// ta.testA1()을 실행시키기 위해 tb가 실행되어야 하고 또 그를 위해선 tc가 실행되어야 함
		ta.testA2();
		
		
		
	}

}
