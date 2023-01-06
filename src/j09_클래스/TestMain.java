package j09_클래스;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String id = null;
		int pw = 0;
				
		Test u1 = new Test();
		
		u1.id = "game";
		u1.pw = 1234;
		u1.level = 100;
		u1.job = "전사";
		u1.playtime = 1000;
		
		boolean loopFlag1 = true;
		while(loopFlag1) {
			System.out.print("ID: ");
			id = scanner.next();
			
			if(id.equals(u1.id)) {
				boolean loopFlag2 = true;
				
				
				for(int i = 0; i < 5; i++) {
					System.out.print("PW: ");
					pw = scanner.nextInt();
					
					if(pw == u1.pw) {
						u1.printUserInfo();
						System.out.println("로그인 성공!");
						loopFlag1 = false;
						break;
					}else {
						System.out.println("PW가 다릅니다. 다시 입력하세요.");
					}
				}
				loopFlag1 = false;
				System.out.println("PW오류 5회. 로그인 차단.");
				System.out.println();
				
			}else {
				System.out.println("등록되지 않은 ID입니다.");
			}
			
		}
		
				
	}

}
