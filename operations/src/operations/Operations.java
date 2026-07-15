package operations;

public class Operations {
	
	public static void main(String[] args) {
		
		int num = 10;
		System.out.println(num++);// 10 나중에 더하는거니까 출력한 이후에 1을 더함 
		System.out.println(++num);// 12 더하고 출력하는거니까 11에서 +1 된거니 12
		
		System.out.println(num--);// 12 출력하고 빼주는거 11
		System.out.println(--num);// 10 출력하기전에 빼고 뺀 값을 출력
		
		int num3 = 3;
		int num4 = 5;
		
		int operResult = num++ + num3*num4; //위에 있는 ++는 한식이 끝났을때 ++ 가 더해짐 이 값은 25
		int operResult1 =num++ + num3*num4; //위에 있는 ++는 한식이 끝났을때 ++ 가 더해짐 이 값은 25
		System.out.println(operResult);
		System.out.println(operResult1); 
		
		
		
		//나누기의 나머지를 구한다.
		int num1 = 10;
		int num2 = 3;
		
		int mod = num1 % num2;
		System.out.println(mod);
		
		int bigNumber = 1_000_000_000;
		int powerResult = bigNumber * bigNumber;
		System.out.println(powerResult);
		
		int maxIntValue = Integer.MAX_VALUE;
		int minIntValue = Integer.MIN_VALUE;
		
		//maxIntValue = maxIntValue + 1; //정수오버플로우
		//minIntValue = minIntValue - 1; //정수언더플로우
		//maxIntValue += 1;
		//minIntValue -= 1;
		maxIntValue++;
		minIntValue--;
		
		System.out.println(maxIntValue);
		System.out.println(minIntValue);
		
		
		//Screaming Snake Case
		final float SUBJECT_COUNT = 3f;
		//subjectCount = 12f;
		
		
		// 평균 계산기
		int kor = 80;
		int math = 90;
		int sci = 93;
		
		float avg = (kor + math + sci)/3f;
		System.out.println(avg);
		//정수와 정수를 연산하면 정수가 튀어나온다 그래서 87.66666 이 아닌 87.0이 나옴
		//묵시적 형변환을 통해서 바꿔줘야함 3을 3f로 바꿔주면됨 정수 / 실수 를 해주면 실수가 나옴
		// 정수 / 정수 를 해봤자 정수만 답으로 나옴
		float avg1 = (kor + math + sci)/SUBJECT_COUNT;
		System.out.println(avg1);
		
		//정수 변수 두개 만들어서 다른 정수 변수에 연산의 결과를 저장한 후 출력한다.
		int firstNumber = 10;
		int secondNumber = 30;
		
		//firstNumber + secondNumber
		int addResult = firstNumber + secondNumber;
		System.out.println(addResult);
		
		//subResult, mulResult, divResult
		
		int subResult = firstNumber - secondNumber;
		System.out.println(subResult);
		
		int mulResult = firstNumber * secondNumber;
		System.out.println(mulResult);
		
		// 타입 (산술연산) 타입 = 같은 타입 int + int = int , int / int = int
 		int divResult = firstNumber / secondNumber;
		System.out.println(divResult);
		
		//
		float firstFloatNumber = 10.5f;
		float secondFloatNumber = 3.55f;
		float divFloatResult = firstFloatNumber / secondFloatNumber;
		System.out.println(divFloatResult);
	}

}
