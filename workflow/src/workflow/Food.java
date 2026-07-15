package workflow;

public class Food {
	public static void main(String[] args) {
		/*
		 * 머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다
		 * 양꼬치는 1인분에 12,000원, 음료수는 2,000원입니다.
		 * 양꼬치 n인분과 음료수 k개를 먹었다면 총얼마를 지불해야하는가
		 */
		
		int meat = 30; // 양꼬치
		int drink = 1; // 음료수
		
		final int MEAT_PRICE = 12000; //양꼬치 가격
		final int DRINK_PRICE = 2000; // 음료수 가격
		
		int freeDrink = 0; // 서비스로 받는 음료수
		
		//만약 고기의 양이 10인분 이상이라면 먹은 먹은 인분/10 의 값이 서비스 음료의 수
		if (meat >= 10) {
			freeDrink = meat / 10; 
		}
		int meatPrice = meat * MEAT_PRICE;
		int drickPrice = drink * DRINK_PRICE;
		int freeDrinkPrice = freeDrink * DRINK_PRICE;
		int totalPrice = meatPrice + drickPrice - freeDrinkPrice;
		
		System.out.println(totalPrice);
		
	}

}
