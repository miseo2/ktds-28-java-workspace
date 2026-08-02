package homework.array;

public class Array {
	
	public static void main(String[] args) {
		
		// 1. 정수형 배열 변수를 만들고 값을 할당해 보세요.
		int[] arrayInt = new int[3];
		arrayInt[0] = 10;
		arrayInt[1] = 20;
		arrayInt[2] = 30;
		
		// 2. 정수형 배열 변수의 합을 계산해 출력해보세요
		// 변수의 햡을 더할 곳
		int intSum = 0;
		
		for (int i = 0; i < arrayInt.length; i++) {
			intSum += arrayInt[i];
		}
		System.out.println(intSum);
		
		// 3. 실수형 배열 변수를 만들고 랜덤한 값을 할당해 보세요.
		float[] arrayFloat = new float[3];
		for (int i = 0;i < arrayFloat.length; i++) {
			arrayFloat[i] = (float) (Math.random() * 10);
			System.out.println(i + "번 값:" + arrayFloat[i]);
		}
		
		// 4. 실수형 배열 변수의 합을 계산해 출력해보세요.
		float fSum = 0;
		
		for (int i = 0; i < arrayFloat.length; i++) {
			fSum += arrayFloat[i];
		}
		System.out.println(fSum);
		
		// 5. 실수형 배열 변수 내의 가장 큰 값을 출력해보세요 .
		float maxFloat = 0;
		
		for (int i = 0; i < arrayFloat.length; i++) {
			if (maxFloat < arrayFloat[i]) {
				maxFloat = arrayFloat[i];
			}
		}
		System.out.println("가장 큰 값: " + maxFloat);
		
		// 6. 실수형 배열 변수 내의 가장 작은 값을 출력해보세요.
		float minFloat = arrayFloat[0];
		
		for (int i = 1; i < arrayFloat.length; i++) {
			if (minFloat > arrayFloat[i]) {
				minFloat = arrayFloat[i];
			}
		}
		System.out.println("가장 작은 값: " + minFloat);
		
		// 7. 문자열형 배열 변수를 만들어 값을 할당해 보세요.
		String[] strArray = new String[3];
		strArray[0] = "라면";
		strArray[1] = "코끼리";
		strArray[2] = "나무늘보";
		
		// 8. 문자열형 배열 변수 내의 값 중 길이가 가장 긴 문자열을 출력해보세요.
		int longString = 0;
		
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].length() > longString) {
				longString = i;
			}
		}
		System.out.println("가장 긴 문자열: " +  strArray[longString]);
		
		// 9. 정수형 배열 변수를 만들고 랜덤한 값을 할당해보세요.
		int[] intArray = new int[5];
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) (Math.random() * 100);
			System.out.println("intArray[" + i + "]의 값: " + intArray[i]);
		}
		
		// 10. 정수형 배열 변수 내의 값 중 평균 이상의 값들만 출력해보세요.
		int arrayAvg = 0;
		int arraySum = 0;
		
		for (int i = 0; i < intArray.length; i++) {
			arraySum += intArray[i];
		}
		System.out.println("정수형 배열의 합: " + arraySum);
		
		arrayAvg = arraySum / intArray.length;
		System.out.println("정수형 변수의 평균: " + arrayAvg);
		
		for ( int i = 0; i < intArray.length; i++) {
			if (intArray[i] > arrayAvg) {
				System.out.println("평균 이상의 값: " + intArray[i]);
			}
		}
	}

}
