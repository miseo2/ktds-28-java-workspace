package practice.problems.zoo;

public class Zoo {
	
	/*멤버변수*/
	// 동물 배열
	private Animal[] animals;
	// 매출
	private int sales; 
	// 입장료
	private int enterFee;
	
	/*생성자*/
	public Zoo(int enterFee) {
		this.enterFee = enterFee;
		this.animals = new Animal[10];
		animals[0] = new Animal("호랑이","호랑이",1000);
		animals[1] = new Animal("사자","사자",2000);
		animals[2] = new Animal("기린","기린",4000);
		animals[3] = new Animal("코끼리","코끼리",3000);
		animals[4] = new Animal("얼룩말","얼룩말",1000);
		animals[6] = new Animal("원숭이","원숭이",2000);
		animals[8] = new Animal("토끼","토끼",6000);
		animals[9] = new Animal("여우","여우",5000);
	}
	
	/*인스턴스 메소드*/
	public void enter() {
		this.sales += this.enterFee;
		System.out.println("입장합니다. 입장료: " + this.enterFee);
	}
	
	public void viewAnimal(int animalIndex) {
		if(this.animals[animalIndex] != null) {
			System.out.println(this.animals[animalIndex].getName() + "동물을 관람합니다.");
			System.out.println("관람료는 " + animals[animalIndex].getPrice() + "원 입니다.");
			this.sales += this.animals[animalIndex].getPrice();
		} else {
			System.out.println("등록된 동물이 없습니다.");
		}
		
	}
	
	public int totalSales() {
		return this.sales;
	}
	
	public static void main(String[] args) {
		
		Zoo zoo1 = new Zoo(10000);
		zoo1.enter();
		zoo1.viewAnimal(7);
		zoo1.viewAnimal(2);
		zoo1.viewAnimal(8);
		zoo1.viewAnimal(1);
		int result = zoo1.totalSales();
		System.out.println(result);
		Zoo zoo2 = new Zoo(15000);
		zoo2.enter();
		zoo2.viewAnimal(9);
		zoo2.viewAnimal(6);
		zoo2.viewAnimal(5);
		zoo2.viewAnimal(3);
		int result2 = zoo2.totalSales();
		System.out.println(result2);
	}

}
