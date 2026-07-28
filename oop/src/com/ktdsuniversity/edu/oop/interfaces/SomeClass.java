package com.ktdsuniversity.edu.oop.interfaces;

// SomeInterface를 구현한 구현 클래스
// 인터페이스를 구현한 클래스는 인터페이스 내부의 메소드(추상메소드)를 구현할 의무가 있다.
public class SomeClass implements SomeInterface{

	@Override
	public void doSomething1() {
		System.out.println("무언가 합니다1");
		
	}

	@Override
	public void doSomething2() {
		System.out.println("무언가 합니다2");
		
	}

	@Override
	public void doSomething3() {
		System.out.println("무언가 합니다3");
		
	}

	@Override
	public int getSomething() {
		return 54735;
	}

	@Override
	public String getString() {
		
		return "sdfsdf";
	}

}
