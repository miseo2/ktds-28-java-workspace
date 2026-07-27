package com.ktdsuniversity.edu.oop.inheritence.car;

public class Vehicle {

	private String name;
	
	public Vehicle(String name) {
		this.name = name;
	}
	
	public void startEngine() {
		System.out.println("[" + this.name + "] 시동을 겁니다.");
	}
	
	public String getName() {
		return this.name;
	}
	
}