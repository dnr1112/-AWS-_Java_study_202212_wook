package j16_Object;

public class ToString {

	public static void main(String[] args) {
		
		Student student1 = new Student("가가가", 10);
		Student student2 = new Student("나나나", 20);
		Student student3 = new Student("다다다", 30);
		Student student4 = new Student("라라라", 40);
		
		System.out.println(student1);						// toString을 override했기 때문에 .toString 없이도 출력가능
		System.out.println(student2);
		System.out.println(student3);
		System.out.println(student4);
		
		System.out.println();
		
		System.out.println(student1.toString());
		System.out.println(student2.toString());
		System.out.println(student3.toString());
		System.out.println(student4.toString());
	}

}
