package j09_클래스;

public class J09_UserMain {

	public static void main(String[] args) {
		
		J09_User u1 = new J09_User();
		J09_User u2 = new J09_User();
		
		u1.username = "aaa";
		u1.password = 1234;
		u1.name = "김종환";
		u1.email = "aaa@gmail.com";
		
		u2.username = "bbb";
		u2.password = 5678;
		u2.name = "김정환";
		u2.email = "bbb@gmail.com";
		
		
		u1.printUserInfo();
		u2.printUserInfo();

	}

}
