package j11_접근지정자;

import j11_접근지정자.default1.J11_StudentDefault;

public class J11_StudentMain {
	
	public static void main(String[] args) {
		J11_Student s1 = new J11_Student("d", 10);
//		s1.name = "황창욱";
		
		s1.printInfo();
		
		J11_StudentDefault s2 = new J11_StudentDefault();
		
//		s2.name = "황창욱1";
//		
//		System.out.println("이름: " + s2.name);
		System.out.println("이름: " + s2.getName());
				
	}
}
