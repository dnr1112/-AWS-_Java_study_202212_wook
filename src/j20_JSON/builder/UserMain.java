package j20_JSON.builder;

public class UserMain {

	public static void main(String[] args) {
		
		User.UserBuilder userBuilder = new User.UserBuilder();
		
		User user2 = User.builder()
				.username("aaa")
				.password("1234")
				.build();
		
		System.out.println(user2);
		
	}

}
