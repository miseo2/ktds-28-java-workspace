package homework.array;

public class ItemMain {
	
	public static void main(String[] args) {
		
		// 12. 상품을 표현하는 클래스의 배열 변수를 만들어보세요.
		Item[] items = new Item[3];
		items[0] = new Item("사과", 2_000);
		items[1] = new Item("오렌지", 1_000);
		items[2] = new Item("수박", 10_000);
		
		// 13. 상품을 표현하는 클래스의 배열 변수에서 가장 비싼 상품의 이름을 출력해보세요.
		// for문으로 비교하기전 0번 인덱스에 있는 items를 가장비싼가격에 우선 넣어준다. 그러고 for문으로 비교
		Item expensivePrice = items[0];
		
		for (int i = 1; i < items.length; i++) {
			if (expensivePrice.getPrice() < items[i].getPrice()) {
				expensivePrice = items[i];
			}
		}
		System.out.println("가장 비싼 상품: " + expensivePrice.getName());
		
		// 14. 상품을 표현하는 클래스의 배열 변수내의 모든 상품의 이름을 출력해보세요.
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i].getName());
		}
		
		
	}

}
