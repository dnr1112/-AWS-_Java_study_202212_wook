package j09_클래스;

public class J09_StudentMain {

	public static void main(String[] args) {

		J09_Student s1 = new J09_Student();
		J09_Student s2 = new J09_Student();
		
		s1.name = "황창욱";
		s1.age = 28;
		
		s1.printInfo();
		
		s2.printInfo();
		
	}

}
