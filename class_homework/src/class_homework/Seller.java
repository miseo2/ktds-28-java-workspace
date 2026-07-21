package class_homework;

/**
 * 판매자
 */

public class Seller {
	
	/**
	 * 상품의 이름
	 */
	String itemName;
	
	/**
	 * 상품의 재고
	 */
	int itemStock;
	
	/**
	 * 상품의 가격
	 */
	int itemPrice;
	
	/**
	 * 매출액
	 */
	int sales;
	
	public Seller(String itemName, int itemStock, int itemPrice) {
		this.itemName = itemName;
		this.itemStock = itemStock;
		this.itemPrice = itemPrice;
	}
	
	public int sell(int num) {
		if (itemStock <= num) {
			num = itemStock;
			System.out.println(itemStock + "개만 구매 가능합니다.");
		} 
		if (itemStock >= num) {
			this.itemStock -= num;
			sales += itemPrice * num;
			System.out.println(num +"개 판매완료");
			System.out.println("판매 매출: " + itemPrice*num);
		}
		return itemPrice * num;
		
	}

}
