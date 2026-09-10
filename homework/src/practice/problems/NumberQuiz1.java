package practice.problems;

import java.util.Scanner;

public class NumberQuiz1 {
	
	private int guessMe;
	
	public NumberQuiz1() {
		//랜덤 숫자 1~10
		this.guessMe = (int)(Math.random()*10) +1;
	}
	
	public boolean answer(int value) {
		if (this.guessMe == value) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		NumberQuiz1 number = new NumberQuiz1();
		System.out.println(number.guessMe);
		
		Scanner keyboard = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자를 입력해주세요(1~10) : ");
			int value = keyboard.nextInt();
			if (number.answer(value) == true) {
				System.out.println("정답입니다.");
				break;
			} else {
				System.out.println("틀렸습니다.");
			}
		}
		keyboard.close();
	}

}
