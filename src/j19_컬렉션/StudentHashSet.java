package j19_컬렉션;

import java.util.HashSet;
import java.util.Set;

public class StudentHashSet {
	
	private static Student searchStudent(Set<Student> students, String searchName) {
		Student student = null;
		
		for(Student s : students) {
			if(s.getName().equals(searchName)) {
				student = s;
				break;
			}
		}
		
		return student;
	}
	
	public static void main(String[] args) {
		Set<Student> students = new HashSet<>();
		
		students.add(new Student("가가가", 10));
		students.add(new Student("나나나", 20));
		students.add(new Student("다다다", 30));
		students.add(new Student("라라라", 40));
		
		System.out.println(students);
		
		Student student = searchStudent(students, "나나나");
		
		if(student == null) {
			System.out.println("검색실패!");
		}else {
			System.out.println("검색성공!" + student);
		}
	}
	
}
