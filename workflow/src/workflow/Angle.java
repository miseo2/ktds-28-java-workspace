package workflow;

public class Angle {
	public static void main(String[] args) {
		/*각에서 
		 * 0도 초과 90도 미만은 예각, 
		 * 90도는 직각 
		 * 90도 초과 180도 미만은 둔각
		 * 180도는 평각 으로 분류합니다.
		 * 예각일때 1, 직각일때 2, 둔각일때 3, 평각일 때 4를 나타내라
		 */
		int angle = 10;
		
		//angle이 0 ~ 90도 사이 일때 예각 1
		if (angle != 0 &&angle < 90) {
			System.out.println("1");
		} 
		// angle이 90도 이면 직각 2
		else if (angle == 90) {
			System.out.println("2");
		} 
		// angle이 90도 ~ 180도 사이 일때 둔각 3
		else if (90 < angle && angle < 180) {
			System.out.println("3");
		} 
		// angle이 180도 이면 평각 34
		else if (angle == 180) {
			System.out.println("4");
		}
		//or 가장 큰 것 부터 역순으로 작성해서 내려오면 논리연산자를 안써도 됨
		
		if (angle == 180) {
			System.out.println("4");
		} else if (angle < 180) {
			System.out.println("3");
		} else if (angle == 90) {
			System.out.println("2");
		} else if (angle < 90) {
			System.out.println("1");
		}
	}

}
