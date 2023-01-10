package j14_추상;		// 공통된 사항을 묶는 것

// 추상 클래스 - 클래스 내에 추상 메소드가 하나라도 있다면, 마찬가지로 추상 클래스
// 1. 생성이 불가함
public abstract class Transportation {		// 교통 : 가고, 멈추다
	
	// 추상 메소드
	public abstract void go();		// 메소드에서 중괄호가 없다? 구현되지 않음
	
	public abstract void stop();
	
}
