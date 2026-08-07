package com.ktdsuniversity.edu.fp.lambda;

import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {
	
	public static void main(String[] args) {
		
		// 문자를 숫자로 변경해본다.
		// "1234" => 1234
		
		//lambda
		String numberFormatString = "1234";
		Function<String, Integer> toNumber = (str) -> Integer.parseInt(str);
		int num = toNumber.apply(numberFormatString);
		System.out.println(num);
		
		// Method Reference
		Function<String, Integer> toNumberRef = Integer::parseInt;
		int num2 = toNumberRef.apply(numberFormatString);
		System.out.println(num2);
		
		// 문자를 문자의 길이로 변경해본다.
		// "abc" => 3, "aaaaa" =>5
		
		// lambda
		Function<String, Integer> toLength = (str) -> str.length();
		int len = toLength.apply(numberFormatString);
		System.out.println(len);
		
		// Method Reference
		Function<String, Integer> toLengthRef = String::length;
		int len2 = toLengthRef.apply("abc");
		System.out.println(len2);
		
		// lambda
		Consumer<String> printer = (str) -> System.out.println(str);
		printer.accept("sdfsdfsdfsd");
		// Method Reference
		Consumer<String> printerRef = System.out::println;
		printerRef.accept("sdfsdfsd");
		
	}

}
