package practice.problems.airplane;

public class Seat {
	
	/*멤버변수*/
	private String name;
	private String grade;
	private int fee;
	//예약 현황 0 - 예약가능 1 -예약 불가능
	private int reservation;
	
	/*생성자*/
	public Seat(String name, String grade, int fee) {
		this.name = name;
		this.grade = grade;
		this.fee = fee;
		this.reservation = (int) (Math.random() * 2) + 1;
	}
	
	/*getter*/
	public int getReservation() {
		return this.reservation;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getFee() {
		return this.fee;
	}

}
