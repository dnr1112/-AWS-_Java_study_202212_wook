package j18_제네릭;

public class Main {

	public static void main(String[] args) {
		TestData<String, Integer> td = new TestData<String, Integer>("가나다", 30);		// 생성될 때 타입을 잡아주면 됨
		TestData<String, Double> td2 = new TestData<String, Double>("라마바", 100.05);
		System.out.println(td);
		System.out.println(td2);

	}

}
