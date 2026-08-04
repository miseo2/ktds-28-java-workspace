package com.ktdsuniversity.edu.oop.enums.food;

public class Food {
	
	public String name;
	private int calories;
	
	/**
	 *  채소
	 *  과일
	 *  고기
	 *  생선
	 *  패스트푸드
	 */
	private FoodType type;

	/**
	 * @param name
	 * @param calories
	 * @param type
	 */
	protected Food(String name, int calories, FoodType type) {
		super();
		this.name = name;
		this.calories = calories;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", calories=" + calories + ", type=" + type + "]";
	}
	// source - Generate toString 클릭하면 toString이 자동으로 생성

}
