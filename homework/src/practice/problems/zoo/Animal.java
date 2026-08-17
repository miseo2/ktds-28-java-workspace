package practice.problems.zoo;

public class Animal {
	
	/*멤버변수*/
	private String type;
	private String name;
	private int price;
	
	/*생성자*/
	public Animal(String type, String name, int price) {
		this.type = type;
		this.name = name;
		this.price = price;
	}
	
	/*인스턴스 메소드*/
	public int see() {
		return this.price;
	}
	
	/*getter*/
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}

}
