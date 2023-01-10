package j15_인터페이스;

public interface Calculator {
	
	public int ERROR = -999999;		// interface는 변수를 가질 수 없기 때문에 final을 생략해도 상수로 입력됨
	
	
	public double plus(double x, double y);		// 오히려 {}를 쓸 수 없음 : 인터페이스는 구현하는 개체가 아님
	
	public double minus(double x, double y);
	
	public default double multiplication(double x, double y) {		// 일반 메소드를 쓸 수 없고, default를 붙여줘야 사용 가능
																	// 또한 일반 변수를 가질 수 없고, 대신 상수는 가질 수 있음
		return x * y;
	}
	
	public double division(double x, double y);
	
}
