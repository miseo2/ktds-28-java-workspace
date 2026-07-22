package com.ktdsuniversity.edu.oop;

import com.ktdsuniversity.edu.oop.exam.Car;
import com.ktdsuniversity.edu.oop.exam.Student;

import java.util.Scanner;



public class Test {
	
	
	
	public static void main(String[] args) {
		
		Student student = new Student(0,0,0,0);
		
		String name ="Adsfsdaf";
		double rnd = Math.random();
		
		Car testCar = new Car(10);
		testCar.pressEngineStartButton();
		System.out.println(testCar.zero100Seconds);
		
		Scanner keyboard = new Scanner(System.in);
	}

}
