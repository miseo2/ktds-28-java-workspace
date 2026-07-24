package array;

import java.util.Arrays;

public class P181852 {

	public int[] solution(int[] num_list) {
		int[] answer = new int[num_list.length-5];
		// 1. num_list를 정렬한다. 
		Arrays.sort(num_list);
		
		// 2. 배열의 순서 5번부터 배열에 넣어준다.
		for (int i = 5; i < num_list.length; i++) {
			answer[i-5] = num_list[i];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] num2 = new int[] {50, 30, 60, 10, 20, 55, 7, 88};
//		int[] num3 = new int[num2.length-5];
		P181852 result = new P181852();
		int[] num3 = result.solution(new int[] {50, 30, 60, 10, 20, 55, 7, 88});
		
		System.out.println(Arrays.toString(num3));
		}
	}


