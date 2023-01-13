package j19_컬렉션;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentArrayList {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Student> students = new ArrayList<>();
		students.add(new Student("가가가", 1));
		students.add(new Student("나나나", 2));
		students.add(new Student("다다다", 3));
		students.add(new Student("라라라", 4));
		
		System.out.println(students);
		
		System.out.println("학생이름 입력: ");
		String searchName = scanner.nextLine();

		
		boolean flag = true;
		for(int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
				if(student.getName().equals(searchName)) {
						student.setYear(4);
						flag = false;
						break;
					}
				}
				if(flag) {
					System.out.println("검색 실패!");
				}
				System.out.println(students);
			}	
}
