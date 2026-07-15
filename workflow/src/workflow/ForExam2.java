package workflow;

public class ForExam2 {
	
	public static void main(String[] args) {
		
		// 1. 1부터 100까지의 합을 구해 출력해보세요
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		// 2. 1부터 100 중 홀수의 합을 구해 출력해 보세요
		int sum1 = 0;
		for (int j = 1; j < 101; j+=2) {
			sum1 += j;
		}
		System.out.println(sum1);
		
		// 3. 1부터 100중 3,5,6의 배수만 출력해보세요
		for (int k = 1; k < 101 ; k++) {
			if (k % 3 == 0) {
				System.out.println(k);
			} else if (k % 5 == 0) {
				System.out.println(k);
			} else if (k % 6 == 0) {
				System.out.println(k);
			}
		}
		
		/*
		 *  4.아래 결과가 나오게 반복문을 작성해보세요.
		 *  *
		 *  **
		 *  ***
		 *  ****
		 *  ***** 
		 */
		
		for (int l = 1; l < 6; l++ ) {
			System.out.println();
			for (int m = 1; m <= l; m++) {
				System.out.print("*");
			}
		}
		
	}

}
