package j12_배열;

import java.util.Random;

public class Array3 {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[] nums = new int[45];

		for(int i = 0; i < nums.length; i++) {
			while(true) {
				boolean findFlag = true;
				
				int randomNum = random.nextInt(nums.length) + 1;
				
				for(int j = 0; j < nums.length; j++) {						// 숫자를 탐색하는 '선형탐색' 알고리즘
					if(nums[j] == randomNum) {
						findFlag = false;
						break;
					}
				}
				
				if(findFlag) {
					nums[i] = randomNum;
					break;
				}
			}
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.println(nums[i]);
		}
		
	}

}
