package practice.problems;

public class Rectangle {
	
	/*멤버변수*/
	private float base;
	private float height;
	
	//직사각형 생성자
	public Rectangle(float base, float height) {
		this.base = base;
		this.height = height;
	}
	
	//정사각형 생성자
	public Rectangle(float base) {
		this.base = base;
		this.height = base;
	}
	
	//인스턴스 메소드
	public float getArea() {
		
		if (this.base == 0 || this.height == 0) {
			System.out.println("계산할 수 없습니다");
			return 0;
		} 
		
		float area = this.base * this.height;
		return area;
	}
	
	public static void main(String[] args) {
		
		Rectangle rectangle1 = new Rectangle(12, 0);
		Rectangle rectangle2 = new Rectangle(1,3);
		Rectangle rectangle3 = new Rectangle(5);
		
		float result1 = rectangle1.getArea();
		System.out.println(result1);
		float result2 = rectangle2.getArea();
		System.out.println(result2);
		float result3 = rectangle3.getArea();
		System.out.println(result3);
		
	}

}
