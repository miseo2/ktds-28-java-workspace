package workflow;

public class ForExam {
	
	public static void main(String[] args) {
		
		//구구단 2단 출력해보자
		for (int i = 1; i<=9; i++) {
			System.out.println("2 X " + i + " = " + ( 2 * i));
		}
		
		// 구구단 2 ~ 9 단까지 출력해보자
		// 2 X 1 -> 2 X 9
		// 3 X 1 -> 3 X 9
		// 4 X 1 -> 4 X 9
		// 5 X 1 -> 5 X 9
		// 6 X 1 -> 6 X 9
		// 7 X 1 -> 7 X 9
		// 8 X 1 -> 8 X 9
		// 9 X 1 -> 9 X 9
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println( i + "X" + j + "=" + (i * j));
			}
		}
	}

}
