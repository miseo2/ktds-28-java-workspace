package array;

import java.util.Arrays;

public class P181853 {
	public int[] solution(int[] num_list) {
		int[] answer = new int[5];
		//1. 배열을 정렬한다.
		Arrays.sort(num_list);
		
		//가장 작은수 5개만 배열에 넣는다.
		for (int i = 0; i < 5; i++) {
			answer[i] = num_list[i];
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] num2 = new int[] {50, 30, 60, 10, 20, 55, 7, 88};
		
		P181853 result = new P181853();
		int[] num3 = result.solution(new int[] {50, 30, 60, 10, 20, 55, 7, 88});
		
		System.out.println(Arrays.toString(num3));
	}

}
