package workflow;

public class ConvStore {
	
	public static void main(String[] args) {
		
		// A 편의점은 한 종류의 음료수만 판매합니다.
		// 음료수 하나의 가격은 3000원 입니다. <-- 상수
		
		// 손님이 가지고 있는 돈, 구매개수 => 변수
		// 5000원을 가지고 있는 손님이 음료수를 3개를 사려고 합니다.
		// 구매할 수 있다면 음료수 가격 X 구매개수를 출력하고
		// 구매할 수 없다면 "금액이 부족합니다."를 출력한다.
		
		
		final int drink = 3000;
		int cash = 5000;
		int num = 3;
		
		if(drink*num <= cash) {
			System.out.println(drink*num);
		}
		else {
			System.out.println("금액이 부족합니다.");
		}
		
		//=================================================
		//B편의점은 한 종류의 음료수만 판매합니다.
		// 총 5개의 음료수가 있으며 음료수 하나의 가격은 4500원입니다. <-- 상수
		
		//30000원을 가지고 있는 손님이 음료수를 n개 구매하려합니다.
		//만약, 손님이 음료수를 5개 이하개를 구매할 수 있으면(금액이 충분하면) 음료수가격 * 구매개수를 출력합니다.
		//그러나 5개 이하개를 구매할 수 없으면 (금액이 충분하지않으면) "재고수가 충분하지 않습니다."를 출력합니다.
		//만약, 손님이 음료수를 6개 구매하려한다면 "재고수가 충분하지 않습니다"를 출력합니다.
		final int DRINK_PRICE = 4500;
		final int DRINK_COUNT = 5;
		
		int cash1 = 30_000;
		int drink1 = 1;
		
		if (drink1 <= DRINK_COUNT && drink1*DRINK_PRICE <= cash1) {
			System.out.println(DRINK_PRICE * drink1);
		}
		else if (drink1 > DRINK_COUNT && DRINK_PRICE * drink1 > cash1) {
			System.out.println("금액이 충분하지 않습니다");
		}
		else if (DRINK_COUNT < drink1) {
			System.out.println("재고수가 충분하지 않습니다.");
		}
		
		int amount = DRINK_PRICE * drink1;
		
		if (drink1 > DRINK_COUNT) {
			System.out.println("재고수가 충분하지않습니다");
		}
		else if (amount <= cash1 ) {
			System.out.println(amount);
		}
		else if (amount > cash1 ) {
			System.out.println("금액이 충분하지않습니다");
		}
		
		
		
		
		
		
	}

}
