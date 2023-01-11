package j16_Object;

class Test{			// public으로 잡으려면 클래스명과 동일해야함, 이 클래스 내에서만 사용할 수 있는 메소드
	private int num;

	public Test(int num) {
		super();
		this.num = num;
		System.out.println(num + "생성");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(num + "객체 소멸");
	}
}

public class ObjectFianlize {

	public static void main(String[] args) {
		Test test = null;
		
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);	// thread를 통해서 gc가 순서대로 실행됨
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test = new Test(i);
						
			test = null;
			
			System.gc();			// 가비지 컬렉터 - 본래는 우선순위가 달라서 순서가 엉망
		}
		
		
	}

}
