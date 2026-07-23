package com.ktdsuniversity.edu.oop.exam.string;

public class Exam {
	
	public static void main(String[] args) {
		// address에 "서울이 포함되어있는지 확인
		String address = "서울특별시 서초구 효령로 176";
		boolean isSeoul = address.contains("서울");
		System.out.println(isSeoul);
		
		// address가 176으로 끝나는지 확인
		isSeoul = address.endsWith("176");
		System.out.println(isSeoul);
		
		//name이 ktdsUniversity와 정확히 같은지 비교
		String name = "ktdsUniversity";
		boolean isEqual = name.equals("ktdsUniversity");
		System.out.println(isEqual);
		
		// name이 ktdsUniversity와 같은지 비교(대소문자 비교안함)
		isEqual = name.equalsIgnoreCase("ktdsuniversity");
		System.out.println(isEqual);
		
		//format 바인딩 기능
		String format = "%s에서 교육하는 %s과정";
		String str = String.format(format, "ktdsuniversity", "Java");
		System.out.println(str);
//		
		// format 바인딩 기능 (Java 15부터 가능)
//		String str = format.formatted("ktdsuniversity", "java");
//		System.out.println(str);
		
		int biggestNumber = Integer.MAX_VALUE;
		System.out.println(biggestNumber);
		
		String numberString = "%,d".formatted(biggestNumber);
		System.out.println(numberString);
		
		//문자 c의 인덱스(위치)찾기
		String alphabets = "abcdefg";
		int letterCIndex = alphabets.indexOf('c');
		System.out.println(letterCIndex);
		
		//문자 C의 인덱스(위치) 찾기
		letterCIndex = alphabets.indexOf('C');
		System.out.println(letterCIndex); // 찾는 문자가 없으니 -1이 나옴
		
		// 문자 def의 인덱스(위치)찾기
		int letterDEFIndex = alphabets.indexOf("def");
		System.out.println(letterDEFIndex);
		
		// str1이 비어있거나 공백으로만 이루어져 있는지 확인 (java11부터)
		String str1 = "   ";
		boolean isBlank = str1.isBlank();
		System.out.println(isBlank);
		
		// str1이 공백으로 비워져있는지 확인
		boolean isEmpty = str1.isEmpty();
		System.out.println(isEmpty);
		
		//message와 name을 "," 으로 연결하기
		String message = "안녕하세요";
		String name1 = "홍길동님";
		String helloMessage = String.join(",", message, name1);
		System.out.println(helloMessage);
		
	}

}
