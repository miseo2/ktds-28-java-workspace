package com.ktdsuniversity.edu.fp.stream;

import java.util.List;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;

public class Reducing {
	
	public static void printLongestNameDish() {
		//이름이 가장 긴 Dish를 출력
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() //Stream<Dish>
			  .reduce(dishes.get(0), (longestDish, eachDish) -> {
				  int longestDishNameLength = longestDish.getName().length();
				  int eachDishNameLength = eachDish.getName().length();
				  
			  })
			  .map(null)
		;
	}
	
	public static void printMaxCalory() {
		// 가장 높은 칼로리를 출력
		List<Dish> dishes = DishList.makeDishList();
		int max = dishes.stream() //Stream<Dish>
						 .map(Dish::getCalories) // Stream<Integer>
						 .reduce(Math::max) //Optional<Integer>
						 .get()
		;
		System.out.println(max);
	}
	
	public static void printMinCaloryOtherDishes() {
		//Other Dish 중에 가장 낮은 칼로리를 출력
		List<Dish> dishes = DishList.makeDishList();
		int min = dishes.stream() //Stream<Dish>
						 .filter(dish -> dish.getDishType() == DishType.OTHER) //Stream<Dish>
						 .map(Dish::getCalories) //Stream<Integer>
						 .reduce(Math::min) //Optional<Integer>
						 .get()
		;
		System.out.println(min);
	}
	
	public static void printMinNumberWithReference() {
		List<Integer> numbers = List.of(123, 123, 4532, 1234, 5346, 432, 26,
				4123,2453,4432, 5);
		
		int min = numbers.stream() //Stream<Integer>
						  .reduce(Integer.MAX_VALUE, Math::min); //Integer
		System.out.println(min);
	}
	
	public static void printMaxNumberWithReference() {
		List<Integer> numbers = List.of(123, 123, 4532, 1234, 5346, 432, 26,
				4123,2453,4432, 5);

		int max = numbers.stream()
						  .reduce(Integer.MIN_VALUE, Math::max);
		System.out.println(max);
	}
	
	public static void printMaxNumber() {
		List<Integer> numbers = List.of(123, 123, 4532, 1234, 5346, 432, 26,
										4123,2453,4432, 5);
		
		int max = numbers.stream()
						  .reduce(Integer.MIN_VALUE, (maxNum, eachNumber) -> {
							  if (maxNum < eachNumber) {
								  return eachNumber;
							  } else {
								  return maxNum;
							  }
						  });
		System.out.println(max);
	}
	
	public static void printSumNumbers() {
		List<Integer> numbers = List.of(123, 123, 4532, 1234, 5346, 432, 26,
										4123,2453,4432, 5);
		int sum = numbers.stream()
						  .reduce(0, (total, eachNumber) -> total + eachNumber);
		
		System.out.println(sum);
	}
	public static void main(String[] args) {
		
//		printMaxNumber();
		
		printMinCaloryOtherDishes();
		printMaxCalory();
		
	}

}
