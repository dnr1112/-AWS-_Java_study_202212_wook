package j09_클래스;

public class Test {
	
	String id;
	int pw;
	int level;
	String job;
	int playtime;
	
	void printUserInfo() {
		System.out.println("레벨: " + level);
		System.out.println("직업: " + job);
		System.out.println("플레이타임: " + playtime + "시간");
		System.out.println();
	}
}
