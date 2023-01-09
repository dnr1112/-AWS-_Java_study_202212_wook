package j12_배열;

public class J12_UserMain {
	
	public static void main(String[] args) {
		
		J12_User[] users = new J12_User[0];
		
		J12_UserRepository userRepository = new J12_UserRepository(users);	// repository를 생성
		
		J12_UserService service = new J12_UserService(userRepository);		// service에서 repository를 사용중이라서
		
		
		service.run();
		service.stop();
	}
}
