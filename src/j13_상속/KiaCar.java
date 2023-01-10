package j13_상속;

public class KiaCar extends Car {
	
	public KiaCar() {
		super();		// 나의 부모(상위객체)를 의미  <->  this(); 자기 자신 호출
		System.out.println("자식");
		
	}
	
	@Override
	public int discountPrice(int percentage) {
		return super.discountPrice(percentage);
	}
	
}
