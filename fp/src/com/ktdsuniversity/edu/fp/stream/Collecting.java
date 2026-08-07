package com.ktdsuniversity.edu.fp.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

public class Collecting {
	
	public static void printCaloryGroups() {
		// 칼로리 별로 그룹을 나누어 출력
		// 400이하 => Diet
		// 700이하 => Normal
		// 700초과 => Fat
		// Map<String, List<Dish>>
		List<Dish> dishes = DishList.makeDishList();
		
		Map<String, List<Dish>> groups = 
				dishes.stream() // Stream<Dish>
					  .collect(Collectors.groupingBy(dish ->{
						  int calory = dish.getCalories();
						  if (calory <= 400) {
							  return "Diet";
						  } else if (calory <= 700) {
							  return "Nomal";
						  }
						  return "Fat";
					  })) // Map<String, List<Dish>>
				;
		groups.forEach((key, value) -> {
			System.out.println(key + "=".repeat(50));
			value.forEach(System.out::println);
		});
	}
	
	public static void printFoodTypeGroups() {
		// Food Type별 Dish 목록을 출력
		List<Dish> dishes = DishList.makeDishList();
		
		Map<FoodType, List<Dish>> groupMap = dishes.stream() // Stream<Dish>
												   .collect(Collectors.groupingBy(dish -> dish.getFoodType()))  //Map<FoodType, List<Dish>>
		; 
		System.out.println(groupMap);
		System.out.println("MEAT =>" +groupMap.get(FoodType.MEAT));
		System.out.println("VEGETABLES =>" +groupMap.get(FoodType.VEGETABLES));
		
	}
	
	public static void printDishTypeGroups() {
		//Dish Type별 Dish 목록을 출력
		List<Dish> dishes = DishList.makeDishList();
		
		Map<DishType, List<Dish>> groupMap = dishes.stream() // Stream<Dish>
												   .collect(Collectors.groupingBy(dish -> dish.getDishType())) //Map<DishType, List<Dish>>
		;
		System.out.println(groupMap);
		System.out.println("OTHER =>" +groupMap.get(DishType.OTHER));
		System.out.println("FISH =>" +groupMap.get(DishType.FISH));
		System.out.println("MAEAT =>" +groupMap.get(DishType.MEAT));
		
		// map 반복하기
		groupMap.forEach((key,value) -> {
			System.err.println(key + "=".repeat(50));
			value.forEach(System.out::println);
		});
	}
	
	public static void printDishNames3() {
		List<Dish> dishes = DishList.makeDishList();
		// 메뉴의 이름들을 칼로리 순으로 내림차순하여 칼로리를 "->" 로 구분해서 출력한다.
		// 결과예시: 800 -> 700 -> 550 -> 530-> ....
		dishes.stream()
		;

	}
	
	public static void printDishNames2(String seperator) {
		List<Dish> dishes = DishList.makeDishList();
		// 메뉴의 이름들을 칼로리 순으로 내림차순하여 이름들을 " ->" 로 구분해서 출력한다.
		//결과 예시: 계절과일 -> 새우 -> 쌀밥 -> -> 치킨....
		String result = dishes.stream() // Stream<Dish>
							  .sorted((dish1, dish2) -> dish1.getCalories() - dish2.getCalories()) // Stream<Dish>
							  .map(Dish::getName) // Stream<String>
							  .collect(Collectors.joining(seperator))
		;
		System.out.println(result);
	}
	
	public static void printDishNames(String seperator) {
		List<Dish> dishes = DishList.makeDishList();
		//메뉴의 이름들을 ","로 구분해서 출력한다.
		// 결과예시 : 돼지고기, 소고기, 치킨, 프랜치 프라이.....
		String result = dishes.stream() // Stream<Dish>
					  .map(Dish::getName) //Stream<String>
					  .collect(Collectors.joining(seperator))
				;
		System.out.println(result);
	}
	
	public static String concatStrings(List<String> strings, String seperator) {
		
		return strings.stream() //Stream<String>
					   .collect(Collectors.joining(seperator)) //String
		;
		
	}
	
	public static Dish getMinCaloryDish() {
		List<Dish> dishes = DishList.makeDishList();
		
		return dishes.stream() //Stream<Dish>
					  .collect(Collectors.minBy((d1, d2) -> d1.getCalories() - d2.getCalories() )) //Optional<Dish>
					  .orElse(null) //Dish
				;
	}
	
	public static Dish getMaxCaloryDish() {
		List<Dish> dishes = DishList.makeDishList();
		
		return dishes.stream() //Stream<Dish>
					  .collect(Collectors.maxBy((d1, d2) -> d1.getCalories() - d2.getCalories() )) //Optional<Dish>
					  .orElse(null) //Dish
		;
	}
	
	public static List<Integer> getDescendingOrderedList(List<Integer> intList) {
		return intList.stream() // Stream<Integer>
						// 내림차순
					   .sorted((n1,n2) -> n2 - n1) // Stream<Integer>
					   // 오름차순
//					   .sorted((n1,n2) -> n1 - n2) // Stream<Integer>

					   .collect(Collectors.toList()) // List<Integer>
				;
	}
	
	public static List<Integer> getOrderdeList ( List<Integer> intList) {
		return intList.stream() // Stream<Integer>
					   .sorted() // Stream<Integer>
					   .collect(Collectors.toList()) // List<Integer>
				;
	}

	public static List<Integer> getEvenNumberList(List<Integer> intList) {
		return intList.stream() // Stream<Integer>
					   .filter(num -> num % 2 == 0) //Stream<Integer>
					   .collect(Collectors.toList()) // List<Integer>
				;
		
		
	}
	
	public static void main(String[] args) {
		List<Integer> evenList = getEvenNumberList(List.of(1,2,3,4,5,6,7,8,9,10,11,12));
		
		evenList.forEach(System.out::println);
		System.out.println("=".repeat(60));
		
		//오름차순 정렬된 리스트를 반환.
		List<Integer> orderedList = getOrderdeList(List.of(9,5,6,1,2,0,-1,777,8));
		orderedList.forEach(System.out::println);
		System.out.println("=".repeat(60));
		
		//오름차순 정렬된 리스트를 반환.
		List<Integer> descList = getDescendingOrderedList(List.of(9,5,6,1,2,0,-1,777,8));
		descList.forEach(System.out::println);
		System.out.println("=".repeat(60));
		
		Dish dish = getMaxCaloryDish();
		System.out.println(dish);
		System.out.println("=".repeat(60));
		
		Dish dish1 = getMinCaloryDish();
		System.out.println(dish1);
		
		String result = concatStrings(List.of("A", "B", "C", "D", "E", "F"), ",");
		System.out.println(result); //A, B, C, D, E, F
		
		result = concatStrings(List.of("A", "B", "C", "D", "E", "F"), "");
		System.out.println(result); //ABCDEF
		
		printDishNames(",");
		printDishNames2("->");
		
		printFoodTypeGroups();
		printCaloryGroups();
	}
}
