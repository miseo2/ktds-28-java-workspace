package com.ktdsuniversity.edu.oop.exam.statics;

public class MathCaculator {
	
	/** 계산하려는 첫 번째 정수 */
	private int firstNumber;
	/** 계산하려는 두 번째 정수 */
	private int secondNumber;
	
	public MathCaculator(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	/**
	 * 숫자 두 개를 연산하여 반환
	 * @param operator 연산 종류
	 * @see com.ktdsuniversity.edu.oop.exam.statics.Operators 연산자 종류
	 * @return operator의 값에 따른 결과
	 */
	public int getComputeResult(int operator) {
		
		if (operator == Operators.ADD) {
			return this.firstNumber + this.secondNumber;
		} else if (operator == Operators.SUB) {
			return this.firstNumber - this.secondNumber;
		} else if (operator == Operators.MUL) {
			return this.firstNumber * this.secondNumber;
		}else if (operator == Operators.DIV) {
			return this.firstNumber / this.secondNumber;
		}else if (operator == Operators.MOD) {
			return this.firstNumber % this.secondNumber;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		MathCaculator math = new MathCaculator(10, 2);
		System.out.println( math.getComputeResult(Operators.ADD));
		System.out.println( math.getComputeResult(Operators.SUB));
		System.out.println( math.getComputeResult(Operators.MUL));
		System.out.println( math.getComputeResult(Operators.DIV));
		System.out.println( math.getComputeResult(Operators.MOD));
	}

}
