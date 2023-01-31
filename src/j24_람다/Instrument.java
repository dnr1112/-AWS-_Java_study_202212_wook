package j24_람다;

@FunctionalInterface	// 람다형 인터페이스라 알려주는 것
public interface Instrument {

	public String play(String instrument);
	
	public default void testPrint() {		// default메소드는 이미 구현됐기 때문에 몇개든 상관없음
		System.out.println("테스트");
	}
	
	
}
