package homework.array;

public class Array2 {
	
	public static void main(String[] args) {
		
		// 15. 숫자 형태의 문자열 배열 변수를 만들어보세요.
		String[] intString = new String[5];
		intString[0] = "10";
		intString[1] = "20";
		intString[2] = "40";
		intString[3] = "60";
		intString[4] = "80";
		
		// 16. 숫자 형태의 문자열 배열 변수의 값을 정수로 변환한 뒤 정수의 합과 평균을 출력해보세요.
		//Integer.parseInt() => 문자열을 int 정수로 변환시켜줌 
		int sum = 0;
		int avg = 0;
		
		for (int i = 0; i < intString.length; i++) {
			sum += Integer.parseInt(intString[i]);
		}
		avg = sum / intString.length;
		
		System.out.println("정수의 합: " + sum + ", 평균: " + avg);
		
		// 17. 불린형태의 배열 변수 값을 랜덤하게 할당하는 방법을 모르겠음 (true, false의 값을 랜덤..?)
		// 17. 불린 형태의 배열 변수를 만들고 값을 랜덤하게 할당해보세요.
		boolean[] bool = new boolean[5];
		int random = 0;
		
		// 0: true 1 : false
		for (int i = 0; i < bool.length; i++) {
			random = (int) (Math.random()*2);
			if (random == 0) {
				bool[i] = true;
				System.out.println(bool[i]);
			} else {
				bool[i] = false;
				System.out.println(bool[i]);
			}
		}
		
		// 18. 불린 형태의 배열 변수 내에서 true의 개수는 몇 개인지 세어 출력해보세요.
		int trueCount = 0;
		for (int i = 0; i < bool.length; i++ ) {
			if (bool[i] == true) {
				trueCount += 1;
			}
		}
		System.out.println("true의 개수: " + trueCount);
		
		// 19. 불린 형태의 배열 변수 내에서 false가 존재하는 비율은 몇 %인지 계산해 출력해보세요.
		int falseCount = bool.length - trueCount;
		
		double percent = (double) falseCount / bool.length * 100;
		System.out.println("false의 비율: " + percent);
		
		
		// 20.  문자열 형태의 배열 변수를 만들고 값을 랜덤하게 할당해보세요. ...?
		// 배열이 두개가 필요한건가..? 
		
	}

}
