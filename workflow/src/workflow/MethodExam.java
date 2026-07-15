package workflow;

public class MethodExam {
	
	//return 값과 타입값은 타입이 같아야한다
	public static double divideTwoNumbers(int number1, int number2) {
		// 명시적 형변환을 해줘서 int/double 이 되서 double이 된다
		double divResult = number1 / (double) number2; 
		return 0;
	}
	
	public static void printNameAndAge(String name, int age) {
		System.out.println("이름: " + name + ", 나이: " + age);
	}
	public static void powerAndPrint(int number) {
		int powerResult = number * number;
		System.out.println(powerResult);
	}
	public static void print() {
		System.out.println("Hello");
		System.out.println(3 + 1);
	}
	public static void main(String[] args) {
		// 단순하게 출력하는 메소드(함수)를 생성하고 호출해본다.
		print();
		print();
		print();
		print();
		// 파라미터(인자)가 있는 메소드(함수)를 생성하고 호출해본다.
		powerAndPrint(2);
		powerAndPrint(3);
		powerAndPrint(5);
		
		// 파라미터(인자)가 여러 개 있는 메소드(함수)를 생성하고 호출해본다.
		printNameAndAge("최미서", 27);
		printNameAndAge("최미서", 27);
		// 반환값(결과)있는 메소드(함수)를 생성하고 호출 한 뒤 결과를 출력해본다.
		//아래 만 적으면 호출만 되고 프린트 되진않음 출력하라는 명령ㅇㄴ 없고 반환하라는 거만
		//있느니까
		divideTwoNumbers(10,3);
		divideTwoNumbers(20,7);
		
		// div1에 반환값을 할당해라
		double div1 = divideTwoNumbers(10,3);
		//할당한 div1의 값을 출력해라
		System.out.println(div1);
		double div2 = divideTwoNumbers(20,7);
	}

}
