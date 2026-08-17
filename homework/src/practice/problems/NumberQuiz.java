package practice.problems;

import java.util.Scanner;

public class NumberQuiz {
	
	/*멤버변수*/
	private int guessMe;
	
	/*생성자*/
	public NumberQuiz() {
		// 1 ~ 10까지
		this.guessMe = (int) (Math.random() * 10) + 1;
	}
	
	/*인스턴스 메소드*/
	public boolean answer(int value) {
		if (this.guessMe == value) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		// 인스턴스 생성하기
		NumberQuiz numberQuiz = new NumberQuiz();
		// 입력 스캐너 생성
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			System.out.print("숫자를 입력해주세요(1 ~ 10): ");
			int value = keyboard.nextInt();
			
			if (numberQuiz.answer(value) == true) {
				System.out.println("정답입니다!");
				break;
			} else {
				System.out.println("틀렸습니다. 다시 맞춰보세요.");
			}
		}
		
		keyboard.close();
		
	}

}
