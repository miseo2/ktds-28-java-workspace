package com.ktdsuniversity.edu.oop.inheritence.car;

public class EV extends Vehicle {

	private float battery;
	
	public EV(String name) {
		this(name, 0f);
	}
	
	public EV(String name, float battery) {
		super(name);
		this.battery = battery;
	}
	
	public void checkBattery() {
		if (this.battery > 0f) {
			System.out.println("[" + super.getName() + "] 배터리가 충분합니다. (" + this.battery + ")");
		} else {
			System.out.println("[" + super.getName() + "] 배터리가 충분하지 않습니다. (" + this.battery + ")");
		}
	}
	
}