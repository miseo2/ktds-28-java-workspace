package com.ktdsuniversity.edu.oop.interfaces.market.item;

public class FreshItem extends Item {
	
	private String expirationDate;
	private int temperature;
	
	public FreshItem (String name, int price) {
		super(name,price);
		this.expirationDate = expirationDate;
	}

}
