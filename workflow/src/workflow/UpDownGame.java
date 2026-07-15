package workflow;

import java.util.Scanner;

public class UpDownGame {
	public static void main(String[] args) {
		//키보드에서 값을 받아올 수 있는 변수하나를 생성한다.
		Scanner keyboard = new Scanner(System.in);
		
		// "업 다운 게임 시작" 출력"
		System.out.println("업 다운 게임 시작");
		
		// 0 ~ 99 사이의 숫자를 임의로 생성
		double randomNumber = Math.random();
		// System.out.println((int) (randomNumber * 100));
		int goal = (int) (randomNumber * 100);
		
		// -1을 주는 이유는 goal 의 값이 0~99까지 이기 때문에 0이 랜덤값으로 되었을때
		// 입력하기도 전에 정답이 출력되버리 그래서 범위의 값이 아닌 다른 값으로 
		// 임의의 값 입력해줌
		int value = -1; 
		while (goal != value) {
			// 사용자로부터 값을 입력 받는다.
			System.out.println("숫자를 입력하세요.");
			value = keyboard.nextInt();
			System.out.println(value);
			
			// 임의의 숫자 == 사용자 입력 값
			// "정답" 을 출력
			if (goal == value) {
				System.out.println("정답");
			}
			// 임의의 숫자 > 사용자의 입력 값
			// "UP" 출력
			else if (goal > value) {
				System.out.println("Up");
			}
			// 임의의 숫자 < 사용자의 입력 값
			// "Down" 출력
			else if (goal < value) {
				System.out.println("Down");
			}
		}
	}

}
