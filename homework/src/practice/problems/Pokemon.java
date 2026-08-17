package practice.problems;

public class Pokemon {
	
	/*멤버변수*/
	private String name;
	private String type;
	private int power;
	private int hp;
	
	/*생성자*/
	public Pokemon(String name, String type, int power, int hp) {
		this.name = name;
		this.type = type;
		this.power = power;
		this.hp = hp;
		
	}
	
	/*인스턴스 메소드*/
	public void attack(Pokemon target) {
		int demage = this.power;
		
		if (this.type.equals("불꽃") && target.type.equals("풀")) {
			demage *= 2 ;
			System.out.println(this.name + "공격력이 2배가 됩니다. 공격력: "+ demage);
		} else if (this.type.equals("풀") && target.type.equals("물")) {
			demage *= 2;
			System.out.println(this.name +"공격력이 2배가 됩니다. 공격력: "+ demage);
		} else if (this.type.equals("물") && target.type.equals("불꽃")) {
			demage *= 2;
			System.out.println(this.name +"공격력이 2배가 됩니다. 공격력: "+ demage);
		} else if (this.type.equals("불꽃") && target.type.equals("물")) {
			demage /= 2;
			System.out.println(this.name +"공격력이 2배 감소합니다. 공격력: "+ demage);
		} else if (this.type.equals("풀") && target.type.equals("불")) {
			demage /= 2;
			System.out.println(this.name +"공격력이 2배 감소합니다. 공격력: "+ demage);
		} else if (this.type.equals("물") && target.type.equals("풀")) {
			demage /= 2;
			System.out.println(this.name +"공격력이 2배 감소합니다. 공격력: "+ demage);
		} 
		
		target.hp -= demage;
		
		System.out.println(this.type+ "타입의 " + this.name + " 포켓몬이 "
						  + target.type + "타입의 " + target.name + " 포켓몬에게 공격했습니다!");
		
		System.out.println(target.name +"의 체력: " + target.hp);
	}
	public static void main(String[] args) {
		
		Pokemon paili = new Pokemon("파이리", "불꽃", 20, 100);
		Pokemon paengdoli = new Pokemon("팽도리", "물", 10, 100);
		Pokemon chikorita = new Pokemon("치코리타", "풀", 30, 100);
		
		paili.attack(chikorita);
		paengdoli.attack(paili);
		chikorita.attack(paengdoli);
		
	}

}
