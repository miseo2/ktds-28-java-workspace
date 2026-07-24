package array;

import java.util.Arrays;

public class P181854 {

	public int[] solution(int[] arr, int n) {
		//int[] answer = new int[arr.length];
		if (arr.length % 2 == 0) {
			for (int i = 1; i < arr.length; i+=2) {
				arr[i] = arr[i] + n;
			}
		} else {
			for (int i = 0; i < arr.length; i+= 2) {
				arr[i] = arr[i] + n;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		
		int[] num2 = new int[] {50, 30, 60, 10, 20, 55, 7, 88};
		P181854 result = new P181854();
		int[] num3 = result.solution(new int[] {50, 30, 60, 10, 20, 55, 7, 88}, 10);
		
		System.out.println(Arrays.toString(num3));
		
		
		
		
	}

}
