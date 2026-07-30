package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.inheritence.car.BatMobile;
import com.ktdsuniversity.edu.oop.inheritence.car.EV;
import com.ktdsuniversity.edu.oop.inheritence.car.SportsCar;
import com.ktdsuniversity.edu.oop.inheritence.car.Vehicle;

public class TestCar {

	public static void startEngine(Vehicle car) {
		car.startEngine();
	}
	
	public static void startTurboEngine(Vehicle car) {
		if (car instanceof SportsCar sc) {
			sc.startTurboEngine();
		}
	}
	
	public static void checkBattery(Vehicle car) {
		if (car instanceof EV ev) {
			ev.checkBattery();
		}
	}
	
	public static void ejectPod(Vehicle car) {
		// car 로 전달된 인스턴스의 타입이 BatMobile이라면
		// ejectBatPob을 실행시켜라.
		if ( car instanceof BatMobile batMobile ) {
			batMobile.ejectBatPod();
		}
	}
	
	public static void main(String[] args) {
		
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Vehicle("클래식카"));
		vehicles.add(new SportsCar("스포츠 카1"));
		vehicles.add(new EV("전기차", 50f));
		vehicles.add(new BatMobile("배트카1"));
		vehicles.add(new BatMobile("배트카2"));
		
//		vehicles[0] = new Vehicle("클래식 카");
//		vehicles[1] = new SportsCar("스포츠 카1");
//		vehicles[2] = new EV("전기차2", 50f);
//		vehicles[3] = new BatMobile("배트카1");
//		vehicles[4] = new BatMobile("배트카2");
		
		for (int i = 0; i < vehicles.size(); i++) {
			startEngine(vehicles.get(i));
			checkBattery(vehicles.get(i));
			startTurboEngine(vehicles.get(i));
			ejectPod(vehicles.get(i));
			
//			startEngine(vehicles[i]);
//			checkBattery(vehicles[i]);
//			startTurboEngine(vehicles[i]);
//			ejectPod(vehicles[i]);
		}
		
//		Vehicle classicCar = new Vehicle("클래식 카");
//		
//		Vehicle sportsCar1 = new SportsCar("스포츠 카1");
//		SportsCar sportsCar2 = new SportsCar("스포츠 카2");
//		
//		Vehicle ev1 = new EV("전기차1");
//		EV ev2 = new EV("전기차2", 50f);
//		
//		Vehicle batCar1 = new BatMobile("배트카1");
//		SportsCar batCar2 = new BatMobile("배트카2");
//		BatMobile batCar3 = new BatMobile("배트카3");
//		
//		startEngine(classicCar);
//		startEngine(sportsCar1);
//		startEngine(sportsCar2);
//		startEngine(ev1);
//		startEngine(ev2);
//		startEngine(batCar1);
//		startEngine(batCar2);
//		startEngine(batCar3);
//		
//		System.out.println();
//		
//		checkBattery(ev1);
//		checkBattery(ev2);
//		
//		System.out.println();
//		
//		startTurboEngine(sportsCar1);
//		startTurboEngine(sportsCar2);
//		
//		System.out.println();
//		
//		ejectPod(sportsCar1);
//		ejectPod(sportsCar2);
//		ejectPod(ev1);
//		ejectPod(ev2);
//		ejectPod(classicCar);
//		ejectPod(batCar1);
//		ejectPod(batCar2);
//		ejectPod(batCar3);
		
	}
	
}