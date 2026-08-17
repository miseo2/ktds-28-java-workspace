package practice.problems;

public class Even {
	
	/*멤버변수*/
	private int num;
	
	/*생성자*/
	public Even(int num) {
		this.num = num;
	}
	
	/*인스턴스 메소드*/
	public void printEven() {
		for(int i = 1; i < this.num; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		System.out.println("짝수 출력이 끝났습니다.");
	}
	
	public static void main(String[] args) {
		
		Even number = new Even(9);
		number.printEven();
		Even number2 = new Even(8);
		number2.printEven();
		
	}

}
