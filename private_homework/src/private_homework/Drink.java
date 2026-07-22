package private_homework;

public class Drink {
	
	/** 주류 이름 */
	private String name;
	
	/** 포만감 */
	private int feelingFull;
	
	/** 취기 */
	private int alcohol;
	
	
	public Drink (String name, int feelingFull, int alcohol) {
		this.name = name;
		this.feelingFull = feelingFull;
		this.alcohol = alcohol;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getFeelingFull() {
		return this.feelingFull;
	}
	
	public int getalcohol() {
		return this.alcohol;
	}

}
