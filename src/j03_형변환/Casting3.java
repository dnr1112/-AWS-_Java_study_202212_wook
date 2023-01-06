package j03_형변환;

public class Casting3 {

	public static void main(String[] args) {
		double kor = 87.5;
		double eng = 95.7;
		double math = 80.5;
		
		int total = 0;
		double avg = 0;
		
		total = ((int) kor + (int) eng + (int) math);
		avg = (double) total/3;
//		double avg = total / 3.0; // 3.0과의 나눗셈을 통해 묵시적으로 double로 형변환이 이루어짐
				
		System.out.println("Total: " + total);
		System.out.println("Average: " + avg);
		
		
	}

}
