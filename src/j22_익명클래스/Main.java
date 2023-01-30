package j22_익명클래스;

public class Main {

	public static void main(String[] args) {
		
		Calculator c1 = new Addition();
		System.out.println(c1.calc(10, 20));
		
///////////////////////////////////////////////////////////////		
		// 한번밖에 쓰지 않을 calculator 인터페이스 때문에 클래스를 새로 생성하지 않기 위함
		Calculator c2 = new Calculator() {
			
			@Override			// 파일로 저장된 건 아니나, 임시로 생성한 것 / 하지만 실제 있는 인터페이스이나 이름이 없어서 '익명 클래스'라 부름
			public int calc(int x, int y) {
				return x - y;
			}
		};
		System.out.println(c2.calc(200, 100));
		
		Calculator c3 = (x, y) -> x * y;		// 12~18번 줄까지를 합친 것
		System.out.println(c3.calc(20, 3));
	}

}
