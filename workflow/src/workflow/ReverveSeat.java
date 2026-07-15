package workflow;

public class ReverveSeat {
	public static void main(String[] args) {
		int [] seats = new int [50];
		
		//랜덤하게 좌석을 배정
		// 0 <-- 예약가능한 좌석
		// 1 <-- 예약불가능한 좌석
		for (int i = 0; i < seats.length; i++) {
			seats[i] = (int) (Math.random() * 2);
		}
		int a = 0; //예약 가능한 좌석
		int b = 0; //예약 불가능한 좌석
		//TODO 배열의 값을 출력
		// " 0 0 1 0 1 1 1 1 0 0 1 0 1 0 0 0 1 0 1 1 1 ..."
		for (int i = 0; i < seats.length; i++) {
			seats[i] = (int) (Math.random() * 2);
			System.out.print(seats[i]);
			
			if (seats[i] == 0) {
				a += 1;
			} else {
				b += 1;
			}
			
		}
		//TODO 예약 가능한 좌석의 수를 출력
		// "n개의 좌석을 예약할 수 있습니다
		System.out.println();
		System.out.println(a +"개의 좌석을 예약할 수 있습니다");
		//TODO 예약 불가능한 좌석의 수를 출력
		// "m개의 좌석이 이미 예약되어있습니다."
		System.out.println(b+"개의 좌석을 예약할 수 있습니다");
	}

}
