package j16_Object;

import java.util.Objects;

public class Student {
	
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();								// object class를 기본적으로 상속하고 있는 상태
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {		// 동일한 주소 = 동일한 값이므로 무조건 참
			return true;
		}
		
		if(obj == null) {
			return false;
		}
		
		if(!(obj.getClass() == Student.class)) {
			return false;
		}
		
		Student s = (Student) obj;		// student를 다운캐스팅
		
		boolean result = name.equals(s.name) && age == s.age;
		
		return result;
	}
	
	@Override
	public String toString() {
		
		return "이름: " + name + "\n나이: " + age;
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(name, age);
	}
	
}
