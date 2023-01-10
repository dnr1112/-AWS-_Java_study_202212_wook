package j13_상속.casting2;

public class Taxi extends Transportation {
	
	@Override		// @로 시작하는 문법을 어노테이션이라 함, 특별한 기능은 없으나 재정의되었다고 표시하는 것
	public void go() {
		System.out.println("택시를 타고 출발");
	}	
	
	@Override
	public void stop() {
		System.out.println("택시를 타고 도착");
	}
	
	public void checkTaxiNumber() {
		System.out.println("택시 번호 확인");
	}

}
