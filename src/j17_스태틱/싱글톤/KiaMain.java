package j17_스태틱.싱글톤;

public class KiaMain {
	
	public static void main(String[] args) {
		KIA kia = KIA.getInstance();		// 주소를 받아올 수 있게끔 만든 것
//		KIA kia2 = new KIA();			// 생성자가 private이기에 생성할 수 없음
		
		kia.printCompanyName();
		
	}
	
}
