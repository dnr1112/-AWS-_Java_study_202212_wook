package j16_Object;

public class ObjectEquals {

	public static void main(String[] args) {
		String name1 = "김준일";
		String name2 = "김준일";
		String name3 = new String("김준일");
		
		System.out.println(name1);
		System.out.println(name2);
		
		System.out.println(name1 == name2);
		System.out.println(name1.equals(name3));
		
		System.out.println("============");
		
		Student s1 = new Student("가가가", 10);
		Student s2 = new Student("가가가", 10);
		SubStudent s3 = new SubStudent("가가가", 10);
		
		System.out.println(s1.equals(s2));		// object의 equals는 기본적으로 주소 비교
		System.out.println(s1.equals(null));
		System.out.println(s1.equals(s3));
		
		
		}

}
