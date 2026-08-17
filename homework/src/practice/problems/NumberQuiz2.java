package practice.problems;

import java.util.Scanner;

public class NumberQuiz2 {
	
	/*멤버변수*/
	// 랜덤할 값을 저장할 변수
	private int guessME;
	// 시도 횟수를 저장할 변수
	private int attempts;
	private int currentAttempts;
	
	/*생성자*/
	public NumberQuiz2(int attempts) {
		// 1 ~ 10
		this.guessME = (int) (Math.random()*10) + 1;
		this.attempts = attempts;
		this.currentAttempts = attempts;
	}
	
	/*getter*/
	public int getAttempts() {
		return this.attempts;
	}

	/* 인스턴스 메소드*/
	public boolean answer(int value) {
		this.attempts -= 1;
		
		// guessMe 와 value값이 맞을때
		if (this.guessME == value) {
			int count = this.currentAttempts - this.attempts;
			System.out.println(count + "회 만에 맞추었습니다.");
			return true;
		// 시도횟수가 남지 않았을때
		} else if (this.attempts <= 0) {
			System.out.println("실패!");
			return false;
		// 시도 횟수가 남아있고 정답을 맞추지 못했을때
		} else {
			System.out.println("시도횟수가 " + this.attempts + "회 남았습니다.");
			return false;
		}
	
		
		
	}
	
	
	public static void main(String[] args) {
		
		NumberQuiz2 numberQuiz2 = new NumberQuiz2(5);
		
		Scanner keyboard = new Scanner(System.in);
		
		
		System.out.print("숫자를 입력해주세요(1~10): ");
		
		while (true) {
			int value = keyboard.nextInt();
			
			if (numberQuiz2.answer(value) == true) {
				break;
			}
			
			if (numberQuiz2.getAttempts() == 0) {
				break;
			}
		}
		
		keyboard.close();
		
		
	}

}
