package com.ktdsuniversity.edu.oop.generics;

/**
 * 
 */

public class Print <D> {
	
	private D printData;
	
	public Print(D printData) {
		this.printData = printData;
	}
	
	public void print() {
		System.out.println(this.printData);
	}
	
	public D getPrintData() {
		return this.printData;
	}


}
