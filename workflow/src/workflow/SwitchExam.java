package workflow;

public class SwitchExam {
	public static void main(String[] args) {
		//라면 끓이기
		//step
		//현재 스탭을 나타낼 수 있는 변수가 필요하다
		int step = 1;
		switch (step) {
			case 1:
				System.out.println("라면을 선택하기");
			case 2:
				System.out.println("냄비를 꺼낸다.");
			case 3:
				System.out.println("냄비에 물을 받는다");
			case 4:
				System.out.println("냄비를 가스레인지에 올린다.");
			case 5:
				System.out.println("가스에 불을 켠다.");
			case 6:
				System.out.println("물이 끓으면 면과 스프를 넣는다.");
			case 7:
				System.out.println("계란 1개를 푼다.");
			case 8:
				System.out.println("불을 끄고 먹는다.");
			default:
				System.out.println("설거지를 한다.");
		
		}
		//1. 라면을 선택하기
		//2. 냄비를 꺼낸다.
		//3. 냄비에 물을 받는다.
		//4. 냄비를 가스레인지에 올린다.
		//5. 가스에 불을 켠다.
		//6. 물이 끓으면 면과 스프를 넣는다.
		//7. 계란 1개를 푼다.
		//8. 불을 끄고 먹는다.
		
		}

}
