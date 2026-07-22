package private_homework;

public class Restaurant {
	
	public static void main(String[] args) {
		/** 음식(이름, 포만감, 취기) */
		Food[] foods = new Food[4];
		foods[0] = new Food("meat", 25, 0);
		foods[1] = new Food("vegetable", 13, -5);
		foods[2] = new Food("fruit", 13, -5);
		foods[3] = new Food("fish", 7, 0);
		
		/** 주류(이름, 포만감, 취기) */
		Drink[] drinks = new Drink[4];
		drinks[0] = new Drink("soju", -7, 17);
		drinks[1] = new Drink("beer", 8, 6);
		drinks[2] = new Drink("whiskey", -7, 40);
		drinks[3] = new Drink("cognac", -7, 40);
		
		/** 고객(나이, 취기, 포만감) */
		Customer[] customers = new Customer[4];
		customers[0] = new Customer(15, 0, 0);
		customers[1] = new Customer(20, 0, 0);
		customers[2] = new Customer(30, 0, 0);
		customers[3] = new Customer(46, 0, 0);
		
		
		// 고객이 레스토랑에 입장한다. (랜덤 1 ~ 4명)
		int customerCount = (int) (Math.random()*4) + 1;
		
		//입장할 고객 수
		System.out.println("입장 고객 수: " + customerCount);
		
		//입장할 고객 명단 작성
		Customer[] enterCustomers = new Customer[customerCount];
		

		
		
		
		//고객이 1명
	}
	
	
	

}
