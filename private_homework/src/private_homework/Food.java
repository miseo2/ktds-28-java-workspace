package private_homework;

public class Food {
	
	/** 음식 이름*/
	private String name;
	
	/** 포만감 */
	private int feelingFull;
	
	/** 취기 */
	private int alcohol;
	
	public Food (String name, int feelingFull, int alcohol) {
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
	
	public int getAlcohol() {
		return this.alcohol;
	}
}
