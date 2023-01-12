package j17_스태틱;

public class StudentMain {

	public static void main(String[] args) {
		Student[] students = new Student[5];
		Teacher[] teachers = new Teacher[5];
		
		students[0] = new Student("가가가");
		students[1] = new Student("나나나");
		students[2] = new Student("다다다");
		students[3] = new Student("라라라");
		students[4] = new Student("마마마");
		
		teachers[0] = new Teacher("AAA");
		teachers[1] = new Teacher("BBB");
		teachers[2] = new Teacher("CCC");
		teachers[3] = new Teacher("DDD");
		teachers[4] = new Teacher("EEE");
		
		for(int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
			System.out.println(teachers[i]);
			System.out.println();
		}
		
		int j = 0;
		for(Student s : students) {
			System.out.println(s);
			System.out.println(teachers[j]);
			System.out.println();
			j++;
		}
		
		System.out.println(Student.getAutoIncrement());
		

	}

}
