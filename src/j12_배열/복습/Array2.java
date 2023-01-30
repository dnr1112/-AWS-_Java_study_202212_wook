package j12_배열.복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User {
	private String username;
	private String password;
	
}


public class Array2 {
	
	public static void main(String[] args) {
		
		User user1 = new User("aaa", "1234");
		User user2 = new User("bbb", "2222");
		User user3 = new User("ccc", "3333");
		
		
		User[] users = new User[3];
		users[0] = new User("aaa", "1234");
		users[1] = new User("bbb", "2222");
		users[2] = new User("ccc", "3333");
		
		User[] users2 = new User[] {
				new User("aaa", "1234"),
				new User("bbb", "2222"),
				new User("ccc", "3333")
		};
		
		for(int i = 0; i<users.length; i++) {
			System.out.println(users[i]);
		}
		
		for(int i = 0; i<users.length; i++) {
			System.out.println(users[i].getUsername());
		}
		
		for(User u : users) {
			System.out.println(u);
		}
		
		System.out.println("========");
		
		List<User> userList = Arrays.asList(users);
		List<User> userList2 = new ArrayList<>(userList);
		
		userList2.add(3, new User("ddd", "1234"));
		
		userList.set(0, new User("ccc", "0000"));
		System.out.println(userList.get(0));
		
		System.out.println(userList2);
		
		
	}
}
