package practice.problems;

public class Computer {
	/*멤버변수*/
	private int number1;
	private int number2;
	
	/* 생성자 */
	public Computer(int number1, int number2) {
		number1 = this.number1;
		number2 = this.number2;
	}
	
	/* 인스턴스 메소드*/
	public int compute(String operator) {
		if (operator == "+") {
			return this.number1 + this.number2;
		} else if (operator == "-") {
			return this.number1 - this.number2;
		} else if (operator == "X") {
			return this.number1 * this.number2;
		} else if (operator == "/") {
			return this.number1 / this.number2;
		} else if (operator == "%") {
			return this.number1 % this.number2;
		} else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		
		Computer computer = new Computer(12, 3);
		int divResult = computer.compute("-");
		System.out.println(divResult);
		
	}
	

}
