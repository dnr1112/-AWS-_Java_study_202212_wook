package j17_스태틱;

import java.time.LocalDateTime;

public class Car {
	
	private static final int NOW_YEAR = LocalDateTime.now().getYear();
	
	private static final String CODE = "KIA-" + NOW_YEAR + "-";
	private static int ai = 1;
	
	private String serialCode;
	private String modelName;
	
	public Car(String modelName) {
		serialCode = CODE + String.format("%04d", ai);
		this.modelName = modelName;
		ai++;
	}

	@Override
	public String toString() {
		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";
	}
	
//	private static int CODE = 0000;
//	private static int num = 1;
//	
//	private int carCode;
//	private String serialCode = "-2023-";
//	private String modelName;
//	
//	
//	public Car(String modelName) {
//		carCode = CODE + num;
//		num++;
//		this.modelName = modelName;
//	}
//	
//	
//	@Override
//	public String toString() {
//		return modelName + serialCode + carCode;
//	}
	
	
}
