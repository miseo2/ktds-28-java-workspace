package com.ktdsuniversity.edu.oop.exam.string;

import java.util.Scanner;

public class WordRelayGame {
	

	
	
	public static void main(String[] args) {
		
		String startWord = "자전거";
		String saveWord = "거";
		String inputWord;
		
		// 1. 시작단어 출력
		System.out.println(startWord);
		

		// Scanner 생성
		Scanner keyboard = new Scanner(System.in);
		String nextWord = null;
		
		while(true) {
			// 이전 단어의 마지막글자로 시작하는 다음단어 입력
			nextWord = keyboard.nextLine();
			nextWord = nextWord.trim();
			
			// 입력받은 글자의 길이를 구해라
			int length = nextWord.length() - 1;
			
			// 입력한 단어는 이전단어의 마지막글자로 시작하는 단어인가?
			if (nextWord.startsWith(saveWord)) {
				// 입력한 글자가 3글자 이상인가
				if (nextWord.length() >= 3) {
					// 입력한 단어의 마지막 글자를 저장한다.
					saveWord = nextWord.substring(length);
					// 입력한 단어를 출력한다.
					System.out.println(nextWord);
				} else {
					System.out.println("3글자 미만 단어입니다. 게임종료");
					break;
				}
			} else {
				System.out.println("이전단어의 마지막 글자로 시작하지않았습니다. 게임종료");
				break;
			}
		}
		
		
		
	}

}
