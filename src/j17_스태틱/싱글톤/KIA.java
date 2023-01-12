package j17_스태틱.싱글톤;

public class KIA {
	
	private static KIA instance = null;		// 싱글톤은 여기서부터 
	
	private KIA() {}		// 생성자가 private이라는 특징
	
	public static KIA getInstance() {
		if(instance == null) {					// instance라는 변수가 null인지 확인
			instance = new KIA();
		}
		return instance;
	}										// 여기까지 항상 세트
	
	public void printCompanyName() {
		System.out.println(getClass().getSimpleName());
	}

}
