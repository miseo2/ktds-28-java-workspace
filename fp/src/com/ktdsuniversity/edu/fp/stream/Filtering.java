package com.ktdsuniversity.edu.fp.stream;

import java.util.List;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

/**
 * 리스트 인스턴스를 스트림 인스턴스로 변환해
 * 필요한 데이터만 추출해내는 실습
 */
public class Filtering {
	
	public static void printLowCaloryFishDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream()
			  .filter((dish) -> dish.getCalories() <= 400)
			  .filter((dish) -> dish.getDishType() == DishType.FISH)
			  .forEach(System.out::println);
//			  .forEach((dish) -> System.out.println(dish))
		;
	}
	
	public static void printFishDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream()
			  .filter((dish) -> dish.getDishType() == DishType.FISH)
			  .forEach(System.out::println)
//			  .forEach((dish) -> System.out.println(dish))
		;
	}
	
	public static void printHighCaloryDishes() {
		// 고 칼로리 기준 : Dish의 칼로리가 800 이상
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream()
			  .filter((dish) -> dish.getCalories() >= 800)
			  .forEach(System.out::println);
//			  .forEach((dish) -> System.out.printlm(dish));
		;
	}
	
	public static void printLowCaloryDishes() {
		// 저 칼로리 기준 : Dish의 칼로리가 400 이하
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream()
			  .filter((dish) -> dish.getCalories() <= 400)
			  .forEach(System.out::println);
//			  .forEach((dish) -> System.out.println(dish));
		;
		
	}
	
	public static void printMeatDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() //Stream<Dish>
			  .filter((dish) -> dish.getFoodType() == FoodType.MEAT) //Stream<Dish>
			  .forEach(System.out::println); //void
//			  .forEach((dish) -> System.out.println(dish))
		;
	}
	
	public static void printVegetableDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() //Stream<Dish>
//			  .peek((dish) -> {
//				  System.out.println("필터링 수행 전");
//				  System.out.println(dish);
//			  })
			  .filter((dish) -> dish.getFoodType() == FoodType.VEGETABLES) //Stream<Dish>
//			  .peek((dish) -> {
//				  System.out.println("필터링 수행 후");
//				  System.out.println(dish);
//			  })
			  .forEach(System.out::println) //void
//			  .forEach((dish) -> System.out.println(dish)) //void
		;
	}
	public static void main(String[] args) {
		
		System.out.println("========================저칼로리면서 생선인 음식 ======================");
		printLowCaloryFishDishes();
		System.out.println("========================생선인 음식 ======================");
		printFishDishes();
		System.out.println("========================고칼로리 음식 ======================");
		printHighCaloryDishes();
		System.out.println("========================저칼로리 음식 ======================");
		printLowCaloryDishes();
		System.out.println("========================고기음식 ======================");
		printMeatDishes();
		System.out.println("========================야채 음식 ======================");
		printVegetableDishes();
	}

}
