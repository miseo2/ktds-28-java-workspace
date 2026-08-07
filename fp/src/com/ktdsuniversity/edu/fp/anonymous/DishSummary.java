package com.ktdsuniversity.edu.fp.anonymous;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;

public class DishSummary {

	private List<Dish> dishes;
	
	public DishSummary() {
		this.dishes = DishList.makeDishList();
	}
	
	public void printAllDishesBy( Predicate<Dish> condition ) {
		
		List<Dish> temp = new ArrayList<>();
		temp.addAll(this.dishes);
		temp.removeIf(condition.negate());
		
		//lambda
		this.dishes.forEach((dish) -> {
			System.out.println(dish);
		});
		//Method Reference
		temp.forEach(System.out::println);
//		for (int i = 0; i < this.dishes.size(); i++) {
//			if ( condition.test(this.dishes.get(i) ) ) {
//				System.out.println(this.dishes.get(i));
//			}
//		}
	}
	
	
	public void printTotalCaloriesBy(Predicate<Dish> condition, Function<Dish, Integer> aggregate) {
		int totalCalories = 0;
		
		for (int i = 0; i <  this.dishes.size(); i++) {
			if ( condition.test(this.dishes.get(i) ) ) {
				totalCalories += aggregate.apply(this.dishes.get(i));
			}
		}
		
		System.out.println(totalCalories);
	}
	
	public void printAverageCaloriesBy(Predicate<Dish> condition, Function<Dish, Integer> aggregate) {
		int totalCalories = 0;
		int size = 0;
		
		for (int i = 0; i <  this.dishes.size(); i++) {
			if ( condition.test(this.dishes.get(i) ) ) {
				size++;
				totalCalories += aggregate.apply(this.dishes.get(i));
			}
		}
		
		System.out.println(totalCalories / (double) size);
	}
	
}










