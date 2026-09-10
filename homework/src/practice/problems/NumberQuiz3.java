package practice.problems;

import java.util.Scanner;

public class NumberQuiz3 {
	
	private int guessMe;
	private int attempts;
	
	public NumberQuiz3(int attempts) {
		this.guessMe = (int) (Math.random()*10)+1;
		this.attempts = attempts;
	}
	
	public boolean answer(int value) {
		int count = attempts;
		attempts--;
		// 시도횟수가 남아있고 정답이라면
		if (attempts >= 0 && this.guessMe == value) {
			System.out.println((count - attempts) + "회 만에 맞추었습니다.");
			return true;
		// 시도횟수가 남아있지 않다면
		} else if(attempts < 0){
			System.out.println("실패!");
			return false;
		// 시도횟수가 남아있지만 정답이 아니라면
		} else {
			System.out.println("시도횟수가"+ attempts +"회 남았습니다.");
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		// 숫자 생성하고 랜덤 숫자 출력
		NumberQuiz3 number = new NumberQuiz3(7);
		System.out.println(number.guessMe);
		
		// 입력받을 거 생성
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요");
		while(true) {
			int value = keyboard.nextInt();
			
			boolean ans = number.answer(value);
			if (ans == va)
		}
		
		
		
		
		
	}

}
