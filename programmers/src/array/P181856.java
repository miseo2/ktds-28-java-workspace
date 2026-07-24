package array;

public class P181856 {

	public int solution(int[] arr1, int[] arr2) {
		int answer = 0;
		int sum = 0;

		
		if (arr1.length != arr2.length) {
			if (arr1.length > arr2.length) {
				answer = 1;
			} else {
				answer = -1;
			}
		} else {
			for (int i = 0; i < arr1.length; i++) {
				sum += arr1[i];
				sum -= arr2[i];
			}
			if (sum > 0) {
				answer = 1;
			} else if (sum < 0) {
				answer = -1;
			} else {
				answer = 0;
			}
		}
		return answer;
		
		
	}
	
	public static void main(String[] args) {
		
		int[] arr1 = new int[] {49, 13};
		int[] arr2 = new int[] {70, 11, 2};
		
		int answer = 0;
		
		P181856 result = new P181856();
		answer = result.solution(arr1, arr2);
		
		System.out.println(answer);
	}

}
