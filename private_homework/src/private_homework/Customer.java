package private_homework;

public class Customer {
	
	/** 나이 */
	private int age;
	
	/** 취기 게이지 */
	private int alcoholStatus;
	
	/** 포만감 게이지 */
	private int feelingFullStatus;
	
	public Customer(int age, int alcoholStatus, int feelingFullStatus) {
		this.age = age;
		this.alcoholStatus = alcoholStatus;
		this.feelingFullStatus = feelingFullStatus;
	}
	
	/**음식을 먹는다.*/
	public void eatFood(Food food) {
		
		// 이 손님의 포만감이 100 이상인가?
		if (this.feelingFullStatus >= 100) {
			System.out.println("배가 불러서 더 이상 먹을 수 없습니다.");
			return;
		}
		
		// 음식의 포만감을 손님의 포만감에 더한다.
		this.feelingFullStatus += food.getFeelingFull();
		
		// 음식의 취기를 손님의 취기에 더한다.
		this.alcoholStatus += food.getAlcohol();
		
		// 포만감이 100을 초과하면 100으로 만든다.
		if (this.feelingFullStatus > 100) {
			this.feelingFullStatus = 100;
		}
		
		// 취기가 0보다 작아지면 0으로 만든다.
		if (this.alcoholStatus < 0) {
			this.alcoholStatus = 0;
		}
	}
	
	/** 술을 마신다.*/
	public void eatDrink(Drink drink) {
		
		// 미성년자인가?
		if (this.age < 20) {
			System.out.println("미성년자는 술을 마실 수 없습니다.");
			return;
		}
		
		// 취기가 100 이상인가?
		if (this.alcoholStatus >= 100) {
			System.out.println("취기가 100 이상이라 더 이상 술을 마실 수 없습니다.");
			return;
		}
		
		// 술의 포만감을 손님의 포만감에 더한다.
		this.feelingFullStatus += drink.getFeelingFull();
		
		// 술의 취기를 손님의 취기에 더한다.
		this.alcoholStatus += drink.getalcohol();
		
		// 포만감이 0보다 작아지면 0으로 만든다.
		if (this.feelingFullStatus < 0) {
			this.feelingFullStatus = 0;
		}
		
		// 포만감이 100을 초과하면 100으로 만든다.
		if (this.feelingFullStatus > 100) {
			this.feelingFullStatus = 100;
		}
		
		// 취기가 100을 초과하면 100으로 만든다.
		if (this.alcoholStatus > 100) {
			this.alcoholStatus = 100;
		}
	}

}
