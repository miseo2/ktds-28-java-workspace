package practice.problems;

public class Circle {
	
	/*멤버변수*/
	//반지름
	private int radius;
	//지름
	private int diameter;
	
	/*생성자*/
	public Circle (int diameter) {
		this.radius = diameter / 2;
		this.diameter = diameter;
	}
	
	/*인스턴스 메소드*/
	public double area() {
		return this.radius * this.radius * Math.PI;
	}
	
	public double round() {
		return this.diameter * Math.PI;
	}
	
	public static void main(String[] args) {
		
		Circle circle = new Circle(10);
		
		double area = circle.area();
		double round = circle.round();
		
		System.out.println(area);
		System.out.println(round);
		
	}

}
