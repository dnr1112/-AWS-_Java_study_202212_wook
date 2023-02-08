package usermanagement.server.controller;

import usermanagement.dto.ResponseDto;
import usermanagement.entity.User;

public class AccountController {

	private static AccountController instance;
	
	private AccountController() {}
	
	public static AccountController getInstance() {
		synchronized (instance) {			// synchronized : 누군가 사용 중이라면 다른사람은 사용 불가 
			if(instance == null) {
				instance = new AccountController(); 
			}
		}
		return instance;
	}
	
	public ResponseDto<?> register(User user) {
		
		return new ResponseDto<String>("ok", "회원가입성공!!");
	}
	
}
