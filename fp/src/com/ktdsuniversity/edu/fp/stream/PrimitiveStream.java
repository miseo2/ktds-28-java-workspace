package com.ktdsuniversity.edu.fp.stream;

import java.util.IntSummaryStatistics;
import java.util.List;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;

public class PrimitiveStream {
	public static void printSummaryStatisticsOfDishes() {
		//모든 Dish의 Calory를 가진 IntStream으로 변환해서
		//summaryStatistics()를 호출한 결과를 출력해본다.
		List<Dish> dishes = DishList.makeDishList();
		
		IntSummaryStatistics Statistics = dishes.stream() // Stream<Dish>
												.map(Dish::getCalories) //Stream<Integer>
												.mapToInt(num -> num) //IntStream
												.summaryStatistics() // IntSummaryStatistics
		;
		System.out.println(Statistics);
		
		int min = Statistics.getMin();
		System.out.println(min);
		
		double average = Statistics.getAverage();
		System.out.println(average);
		
		long sum = Statistics.getSum();// 대량의 데이터라서 int합계를 하는 거면 10억 + 20억 = 30억 이지만 오버플로우로 -값이나올것이다 이를 방지하기위해 long으로 표현
		System.out.println(sum);
		
		long count = Statistics.getCount(); // 대량의 데이터라서 int를 카운트를 하는 것이더라도 100억개의 갯수가 있으면 int로 표현 못함
		System.out.println(count);
	}
	
	public static void printDishesAverageCalory() {
		// 모든 Dish의 평균 Calory를 구해서 출력한다.
		List<Dish> dishes = DishList.makeDishList();
		
		double average = dishes.stream() // Stream<Dish>
								  .map(Dish::getCalories) // Stream<Integer>
								  .mapToInt(num -> num) //IntStream
								  .average() //OptionalDouble
								  .orElse(-1)
		;
		System.out.println(average);
	}
	
	public static void printMinNumber() {
		List<String> numbers = List.of("123","4656","5866","132","4446","5666","4899","521","321","3","21");
		
		// numbers에서 가장 작은 값을 찾아 출력한다.
		int min = numbers.stream() //Stream<Integer>
						  .mapToInt(str -> Integer.parseInt(str)) //IntStream
						  .min() //OptionalInt
						  .orElse(-1)
		;
		System.out.println(min);
	}
	
	public static void printMaxNumber() {
		List<Integer> numbers = List.of(123,4,5,132,4,5,48,521,321,3,21,8,7465,21,32);
		
		int max = numbers.stream() //Stream<Integer>
						  .mapToInt(num -> num) //IntStream
						  .max() //OptionalInt
						  .orElse(-1)
		; 
		System.out.println(max);
	}
	
	public static void printSumNumvers() {
		List<Integer> numbers = List.of(123,4,5,132,4,5,48,521,321,3,21,8,7465,21,32);
		
		int sum = numbers.stream() // Stream<Integer>
						  .mapToInt(num -> num) // IntStream
						  .sum() // int
		;
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		printMinNumber();
	}

}
