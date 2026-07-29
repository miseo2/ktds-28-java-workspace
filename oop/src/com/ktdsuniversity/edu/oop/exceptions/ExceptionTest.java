package com.ktdsuniversity.edu.oop.exceptions;

public class ExceptionTest {
	
	public static void main(String[] args) {
		
		String name = null;
		// name이라는 인스턴스의 값이 null이라면 "이름을 입력해주세요"를 출력한다.
		// name이라는 인스턴스의 값이 null 이 아니라면 값을 출력한다.
		if (name == null) {
			System.out.println("이름을 입력해주세요");
		} else {
			System.out.println(name);
		}
		
		String job = "";
		// job이라는 인스턴스의 값이 ""이라면 "직업을 입력해주세요"를 출력한다.
		// 아니라면 값을 출력한다.
		if (StringUtils.isEmpty(job)) {
			System.out.println("직업을 입력해주세요");
		} else {
			System.out.println(job);
		}
		
		String address = "    ";
		// address라는 인스턴스의 값이 공백으로만 이루어져 있다면 "주소를 입력해주세요"를 출력한다.
		// 아니라면 값을 출력한다.
		String message = StringUtils.emptyToDefault(address, "주소를 입력해주세요.");
		System.out.println(message);
	}

}
