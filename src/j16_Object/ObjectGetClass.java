package j16_Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ObjectGetClass {

	public static void main(String[] args) {
		Student student = new Student("나나나", 20);
		
		System.out.println(student.getClass());
		System.out.println(Student.class);
		
		System.out.println(student.getClass().getName());	// 얘랑
		
		Class studentClass = student.getClass();
		
//		studentClass.getName();								// 얘랑 같은 거
		
		String className = studentClass.getName();
		System.out.println("클래스 이름: " + className);
		
		String simpleName = studentClass.getSimpleName();
		System.out.println("클래스 이름만: " + simpleName);
		
		Field[] fields = studentClass.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field);
		}
		
		System.out.println();
		
		Method[] methods = studentClass.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
	}

}
