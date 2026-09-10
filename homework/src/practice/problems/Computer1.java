package practice.problems;

public class Computer1 {
	
	private int number1;
	private int number2;
	
	public Computer1(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}
	
	public int compute(String operator) {
		if (operator.equals("+")) {
			return this.number1 + this.number2;
		}else if (operator.equals("-")) {
			return this.number1 - this.number2;
		}else if (operator.equals("x")) {
			return this.number1 * this.number2;
		}else if (operator.equals("/")) {
			return this.number1 / this.number2;
		}else if (operator.equals("%")) {
			return this.number1 % this.number2;
		} else if (operator.equals("**")) {
			return (int)Math.pow(this.number1, this.number2);
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		Computer1 computer = new Computer1(12,3);
		int result = computer.compute("x");
		System.out.println(result);
	}

}
