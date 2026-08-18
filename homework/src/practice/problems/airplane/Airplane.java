package practice.problems.airplane;

public class Airplane {
	
	/*멤버변수*/
	private Seat[] seats;
	private String number;
	
	/*생성자*/
	public Airplane(Seat[] seats, String number) {
		this.seats = seats;
		this.number = number;
	}
	
	/*인스턴스 메소드*/
	public void reservedSeat() {
		int count = 0;
		for (int i = 0; i < seats.length; i++ ) {
			if (seats[i].getReservation() == 1) {
				count++;
			}
		}
		System.out.println(seats.length + "개의 좌석 중 " + count+ "개가 예약완료되었습니다.");
	}
	
	public void reserve(String name) {
		//좌석이 있는지 없는지
		boolean isSeat = false;
		for (int i = 0; i < seats.length; i++) {
			if (this.seats[i].getName().equals(name)) {
				if (this.seats[i].getReservation() == 1) {
					System.out.println(seats[i].getName()+"좌석은 이미 예약되어 있는 좌석입니다. 다른 좌석을 이용해 주세요.");
					isSeat = true;
				} else {
					System.out.println(seats[i].getName()+"좌석을 "+ seats[i].getFee()+"원으로 예약했습니다.");
					this.seats[i].setReservation(1);
					isSeat = true;
				}
			}
		}
		
		if (!isSeat) {
			System.out.println("존재하지 않는 좌석입니다.");
		}
	}
	
	public static void main(String[] args) {
		
		Seat[] seats = new Seat[3];
		
		seats[0] = new Seat("A1", "이코노미", 50000);
		seats[1] = new Seat("A2", "비지니스", 100000);
		seats[2] = new Seat("A3", "퍼스트클래스", 150000);
		
		Airplane airplane = new Airplane(seats,"A2562");
		airplane.reservedSeat();
		airplane.reserve("A1");
		airplane.reserve("A2");
		airplane.reserve("A3");
		airplane.reserve("B3");
	}

}
