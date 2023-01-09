package j12_배열;

public class DoubleArray1 {

	public static void main(String[] args) {
		
		int num = 0;
		
		int[] nums = new int[2];			// int 배열을 담을 수 있는 공간
		
		int[][] d_nums = new int[3][2];		// int 배열을 담을 수 있는 배열을 담을 수 있는 공간 -> 2개짜리 배열이 3개로 묶였다는 뜻
//		뒤쪽 []가 하위
		
		d_nums[0][0] = 1;
		d_nums[0][1] = 4;
		
		d_nums[1][0] = 2;
		d_nums[1][1] = 5;
		
		d_nums[2][0] = 3;
		d_nums[2][1] = 6;
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println(d_nums[j][i]);
			}
		}
		
		int[][] d_nums2 = new int[][] {{1, 2, 3}, {4, 5, 6}};		// 앞의 묶음이 뒤쪽 배열에 해당됨
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println(d_nums2[i][j]);
			}
		}
		
		System.out.println(d_nums2.length);		// 위에서 큰 묶음의 길이가 2기 때문
		
		System.out.println(d_nums2[0].length);	// 배열 내 배열의 길이를 위해선 해당 index에 있는 배열의 length를 넣어준다
		
		
		int[][] d_nums3 = new int[][] {{1, 2, 3}, {5, 6}};		// 배열의 길이가 서로 다른 경우
		
		for(int i = 0; i < d_nums3.length; i++) {
			for(int j = 0; j < d_nums3[i].length; j++) {		// [i]를 넣어줌으로써 배열의 길이가 다를때를 해결
				System.out.println(d_nums2[i][j]);
			}
		}
		
	}

}
