package homework.array;
/**
 * 상품을 표현하는 클래스
 */
public class Item {
	
	private String name; // 상품의 이름
	private int price; // 상품의 가격
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}

}
