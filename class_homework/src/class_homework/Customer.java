package class_homework;

/**
 * 구매자
 */

public class Customer {

	/**
	 * 구매자가 보유한 현금
	 */
	int cash;
	
	/**
	 * 구매 상품
	 */
	String itemName;
	
	/**
	 * 구매 수량
	 */
	int count;
	
	
	/**
	 * 장바구니
	 */
	int[] cart;
	
	public Customer (String itemName, int cash, int count) {
		this.itemName = itemName;
		this.cash = cash;
		this.count = count;
		
	}
	
	public void buy(String itemName, int price, int count, int cash) {
		
	}
	

	
}
