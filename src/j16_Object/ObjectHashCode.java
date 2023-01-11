package j16_Object;

public class ObjectHashCode {

	public static void main(String[] args) {
		Student s1 = new Student("가가가", 10);
		Student s2 = new Student("가가가", 10);
		SubStudent s3 = new SubStudent("가가가", 10);
		
		System.out.println(s1.hashCode());		// 문자열, 숫자 등으로 해시코드를 짬
		System.out.println(s2.hashCode());
		
		System.out.println(s1.hashCode() == s2.hashCode());
		System.out.println(s1.hashCode() == s3.hashCode());		// equals와 달리, 객체가 달라도 값만 같다면 비교가 가능함
		
	}

}
