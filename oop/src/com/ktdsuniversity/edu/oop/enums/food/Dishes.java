package com.ktdsuniversity.edu.oop.enums.food;

public class Dishes {
	
	public static void main(String[] args) {
		Food bigmac = new Food("빅맥", 900, FoodType.FASTFOOD );
		Food apple = new Food("사과", 100, FoodType.FRUIT );
		Food fish = new Food("물고기", 500, FoodType.FISH );

		System.out.println(bigmac);
		
		Food mara = new Food("마라상궈", 1200, FoodType.FISH);
	}

}
