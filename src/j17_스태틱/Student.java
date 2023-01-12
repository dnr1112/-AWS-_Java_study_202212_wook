package j17_스태틱;

public class Student {
	
	private static final int CODE = 20230000;
	private static int ai = 1;		// auto_increment
	
	private int studentCode;
	private String name;
	
	public Student(String name) {
		studentCode = CODE + ai;
		ai++;
		this.name = name;
	}
	
	public static int getAutoIncrement() {			// static 메소드 안에서는 static 변수만 사용할 수 있음
//		int num = 10;								// 지역변수는 사용가능, 전역변수로는 static 변수만 사용가능
		System.out.println("현재 AI: " + ai);
//		System.out.println("학생이름: "+ name);		// name은 생성이 되어야만 사용할 수 있는 변수기 때문에 사용불가
		return ai;
	}
	
	
	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}
	
	
	
}
