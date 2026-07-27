package com.ktdsuniversity.edu.oop.inheritence.car;

public class SportsCar extends Vehicle {

	public SportsCar(String name) {
		super(name);
	}
	
	public void startTurboEngine() {
		System.out.println("[" + super.getName() + "] 터보 모드를 시작합니다.");
	}
	
}