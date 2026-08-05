package com.ktdsuniversity.edu.fp.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NativeFunction {
	
	public static void main(String[] args) {
		
		// Predicate<T> => T를 받아서 boolean을 반환시킨다.
		Predicate<String> isEmpty = (str) -> str == null || str.isBlank();
		System.out.println(isEmpty.test(null));
		System.out.println(isEmpty.test("   "));
		System.out.println(isEmpty.test("Asdfddfsfd"));
		
		// Consumer<T> => T를 받아서 void를 반환시킨다.
		Consumer<String> print = (str) -> System.out.println(str);

		print.accept("sfsdfsdfsd");
		
		// Function<T, R> => T를 받아서 R을 반환시킨다/
		// String을 파라미터로 전달해서 문자열의 길이를 반환 시키는 함수.
		Function<String, Integer> getLength = (str) -> str.length();
		int len = getLength.apply("sdfsdfsdfsdfsd");
		System.out.println(len);
		
		// String을 파라미터로 전달해서 숫자로 변경해주는 반환 시키는 함수.
		Function<String, Integer> getInt = (str) -> Integer.parseInt(str);
		int strInt = getInt.apply("23");
		System.out.println(strInt);
		
		// Integer를 파라미터로 전달해서 문자로 변경해주는 함수.
		Function<Integer, String> getStr = (i) -> i.toString(i);
		String strIn = getStr.apply(50);
		System.out.println(strIn);
		
		// Integer를 파라미터로 2의 배수만 truefh 반환시켜주는 함수.
		
	}

}
