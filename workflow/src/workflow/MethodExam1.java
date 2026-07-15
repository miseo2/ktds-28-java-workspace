package workflow;

public class MethodExam1 {
	// 1번 메소드
	public static void method1(int num1, int num2) {
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2);
	}

	// 2번 메소드
	public static boolean method2(int num1) {
		boolean result;
		if (num1 % 2 == 0) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	// 3번 메소드
	public static void method3(int num1, int num2, int num3) {
		int bigNum = 0;
		if (num1 >= num2 && num1 >= num3) {
			bigNum = num1;
		} else if (num2 >= num1 && num2 >= num3) {
			bigNum = num2;
		} else {
			bigNum = num3;
		}
		System.out.println(bigNum);
	}
	
	// 4번 메소드
	public static boolean method4(int num) {
		boolean result = true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				result = false;
				break;
			} else {
				result = true;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		
		// 1. 정수 두개를 받아서 사칙연산(+, - , X, /)의 결과를 출력하는 메서드를 만들고 호출해보세요.
		method1(4,2);
		
		// 2. 정수 한 개를 받아서 짝수라면 true를, 홀수라면 false를 반환하는 메소드를 만들고 호출해보세요.
		boolean result1 = method2(2);
		System.out.println(result1);
		
		boolean result2 = method2(3);
		System.out.println(result2);
		
		// 3. 정수 세 개를 받아서 가장 큰 수를 출력하는 메소드를 만들고 호출해보세요
		method3(1, 2, 3);
		method3(5, 3, 2);
		
		// 4. 정수 한 개를 받아서 소수(prime number)라면 true를 아니라면 false를 반환하는 메소드를 만들고 호출해 보세요.
		boolean result3 = method4(7);
		System.out.println(result3);
		boolean result4 = method4(9);
		System.out.println(result4);
	}

}
