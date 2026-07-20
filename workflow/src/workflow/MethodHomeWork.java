package workflow;

public class MethodHomeWork {
	// 1번
	public static void method1(int num1, int num2) {
		System.out.println(num1);
		System.out.println(num2);
		
	}
	
	// 2번
	public static void method2 (int num1, int num2) {
		int sum = 0;
		sum = num1 + num2;
		System.out.println(sum);
	}
	
	// 3번
	public static int method3 (int num1, int num2, int num3) {
		int sum = 0;
		sum = num1 + num2 + num3;
		return sum;
	}
	
	// 4번
	public static void method4 (int num1, int num2) {
		float a = 0;
		a = (float) num1 / num2;
		System.out.println(a);
	}
	
	// 5번
	public static float method5 (int num1, int num2) {
		float b = 0;
		b = (float) num1 / num2;
		return b;
	}
	
	// 7번
	public static float method7 (float numF1, float numF2) {
		float bigNum = 0;
		if (numF1 > numF2) {
			bigNum = numF1;
		} else {
			bigNum = numF2;
		}
		return bigNum;
	}
	
	// 8번
		public static float method8(float numF1, float numF2, float numF3, float numF4) {
			float smallNum = numF1;
			
			if (smallNum > numF2) {
				smallNum = numF2;
			}
			
			if (smallNum > numF3) {
				smallNum = numF3;
			}
			
			if (smallNum > numF4) {
				smallNum = numF4;
			}
			
			return smallNum;
		}
		
		// 9번
		public static void method9(int[] numbers) {
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] % 2 == 0 || numbers[i] % 5 == 0 || numbers[i] % 8 == 0) {
					System.out.print(numbers[i] + " ");
				}
			}
			System.out.println();
		}
		
		// 10번
		public static void method10(String text, int count) {
			for (int i = 0; i < count; i++) {
				System.out.print(text + " ");
			}
			System.out.println();
		}
		
		
		// 11번
		public static void method11(int num) {
			for (int i = 1; i <= 9; i++) {
				System.out.println(num + " X " + i + " = " + (num * i)); 
			}
			
		}
		
		// 13번
		public static int method13(int[] numbers, int i) {
			if (i >= 0 && i < numbers.length) {
				return numbers[i];
			}
			
			return 0;
		}
		
		// 14번
		public static int method14(int[] numbers2) {
			for (int i = 0; i < numbers2.length; i++) {
				if (numbers2[i] % 3 == 0) {
					return numbers2[i];
				}
			} return -1;
		}
		
		// 15번
		public static void method15(int[] numbers3, int[] numbers4) {
			for (int i = 0; i < numbers3.length; i++) {
				for (int j = 0; j < numbers4.length; j++) {
					if (numbers3[i] == numbers4[j]) {
						System.out.print(numbers4[j] + " ");
					}
				}
			}
			System.out.println();
		}
		
		// 16번
		public static void method16(int[] numbers3, int[] numbers4) {
			for (int i = 0; i < numbers3.length; i++) {
				for (int j = 0; j < numbers4.length; j++) {
					if (numbers3[i] == numbers4[j]) {
						break;
					}
				} 
			}
			System.out.println();
		}
		
		// 17번
		public static void method17(int[] numbers3) {
			for (int i = 0; i <numbers3.length; i++) {
				numbers3[i] = numbers3[i] * 2;
			}
		}
	
	public static void main(String[] args) {
		// 정수형 변수
		int num1 = 7;
		int num2 = 2;
		int num3 = 7;
		
		float numF1 = 5.333f;
		float numF2 = 7.2435f;
		float numF3 = 10.36f;
		float numF4 = 2.25f;
		
		//1. 정수형 변수 2개를 파라미터로 받아, 값을 출력하는 메소드.
		method1(num1, num2);
		
		//2. 정수형 변수 2개를 파라미터로 받아, 합계를 출력하는 메소드.
		method2(num1, num2);
		
		//3. 정수형 변수 3개를 파라미터로 받아, 합계를 반환하는 메소드.
		int sum3 = 0;
		method3(num1, num2, num3);
		sum3 = method3(num1, num2, num3);
		
		//4. 정수형 변수 2개를 파라미터로 받아, 나누기의 결과(실수)를 출력하는 메소드.
		method4(num1, num2);
		//5. 정수형 변수 2개를 파라미터로 받아, 나누기의 결과(실수)를 반환하는 메소드.
		float flo1 = 0;
		method5(num1, num2);
		flo1 = method5(num1, num2);
		System.out.println(flo1);
		
		//6. 실수형 변수 1개와 정수형 파라미터 1개를 받아 소수점 이하 자리수를 변경하여 반환하는 메소드.
		//   -> 예> 소수점 변경(10.33333333, 2) ==> 10.33 
		//   -> 예> 소수점 변경(10.33333333, 3) ==> 10.333
		//   -> 예> 소수점 변경(10.33333333, 1) ==> 10.3
		//   -> 예> 소수점 변경(10.33333333, 0) ==> 10.0
		
		//7. 실수형 변수 2개를 파라미터로 받아, 가장 큰 수만 반환하는 메소드.
		float bigNum = method7(numF1, numF2);
		System.out.println(bigNum);
		
		//8. 실수형 변수 4개를 파라미터로 받아, 가장 작은 수만 반환하는 메소드.
		float smallNum = method8(numF1, numF2, numF3, numF4);
		System.out.println(smallNum);
		//9. 정수 배열을 파라미터로 받아, 2,5,8 배수인 숫자만 출력하는 메소드.
		int[] numbers = new int[5];
		numbers[0] = 1;
		numbers[1] = 2;
		numbers[2] = 5;
		numbers[3] = 8;
		numbers[4] = 3;
		method9(numbers);
		
		//10. 문자열 1개와 정수형 변수 1개를 파라미터로 받아, 문자열을 정수형 변수만큼 반복 출력하는 메소드.
		method10("Hello", 3);
		
		//11. 정수형 변수 1개를 파라미터로 받아, 해당 정수의 구구단을 출력하는 메소드.
		method11(num2);
		//12. 정수형 변수 1개를 파라미터로 받아, 4부터 정수형 변수까지의 범위 중 소수(Prime Number)만 출력하는 메소드.
		
		/*
		 * 13. 정수형 배열 변수 1개와 정수형 변수 1개를 파라미터로 받아, 해당 배열의 정수형변수 인덱스에 의 값을 반환하는 메소드.
			-> 예> 값(길이가 5인 배열, 2) ==> 배열의 2번 인덱스의 값
			-> 예> 값(길이가 5인 배열, 4) ==> 배열의 4번 인덱스의 값
			-> 예> 값(길이가 5인 배열, 5) ==> 0
			-> 예> 값(길이가 5인 배열, -1) ==> 0
			-> 예> 값(길이가 5인 배열, 1) ==> 배열의 1번 인덱스의 값
			-> 예> 값(길이가 5인 배열, 0) ==> 배열의 0번 인덱스의 값
			-> 예> 값(길이가 5인 배열, 3) ==> 배열의 3번 인덱스의 값
			-> 예> 값(길이가 5인 배열, 7) ==> 0
		 */
		int index = 0;
		index = method13(numbers, 1);
		System.out.println(index);
		
		/*
		 * 14. 정수형 배열 변수 1개를 파라미터로 받아, 가장 처음 나오는 3의 배수만 반환하는 메소드
			- 정수형 배열 변수내부에 3의 배수가 없을 경우 -1 을 반환.
		 */
		int [] numbers2 = new int [5];
		numbers2[0] = 2;
		numbers2[1] = 7;
		numbers2[2] = 5;
		numbers2[3] = 1;
		numbers2[4] = 10;
		
		int result = method14(numbers2);
		System.out.println(result);
		/*
		 * 15. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복값만 출력하는 메소드.
			-> 예> 중복([1,2,3,4,5], [9,7,454,1,2,3]) ==> 1 2 3
			-> 예> 중복([1,2,3,4,5], [1,2,3,4,5]) ==> ""
		 */
		int [] numbers3 = new int [5];
		numbers3[0] = 1;
		numbers3[1] = 2;
		numbers3[2] = 3;
		numbers3[3] = 4;
		numbers3[4] = 5;
		
		int [] numbers4 = new int [6];
		numbers4[0] = 9;
		numbers4[1] = 7;
		numbers4[2] = 454;
		numbers4[3] = 1;
		numbers4[4] = 2;
		numbers4[5] = 3;
		
		method15(numbers3, numbers4);
		/*
		 * 16. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복되지 않는 값만 출력하는 메소드.
			-> 예> 고유([1,2,3,4,5], [9,7,454,1,2,3]) ==> 4, 5, 9. 7, 454
			-> 예> 고유([1,2,3,4,5], [1,2,3,4,5]) ==> ""
		 */
		
		method16(numbers3, numbers4);
		
		/*
		 * 16. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복되지 않는 값만 출력하는 메소드.
			-> 예> 고유([1,2,3,4,5], [9,7,454,1,2,3]) ==> 4, 5, 9. 7, 454
			-> 예> 고유([1,2,3,4,5], [1,2,3,4,5]) ==> ""
		 */
		
		/*
		 * 17. 정수형 배열 변수 1개를 파라미터로 받아, 모든 값들을 배수로 만드는(반환X) 메소드.
			-> 호출 이후에 main 메소드 내부에서 배열 내부의 값들을 모두 출력.
		 */
		System.out.println(numbers3[0]);
		System.out.println(numbers3[1]);
		System.out.println(numbers3[2]);
		System.out.println(numbers3[3]);
		System.out.println(numbers3[4]);
		method17(numbers3);
		System.out.println(numbers3[0]);
		System.out.println(numbers3[1]);
		System.out.println(numbers3[2]);
		System.out.println(numbers3[3]);
		System.out.println(numbers3[4]);


	}

}
