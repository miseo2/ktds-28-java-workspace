package com.ktdsuniversity.edu.oop.cafe;

public class ComicsBook {
	
	/** 책 이름*/
	private String name;
	/** 책의 대여 가능 여부*/
	private boolean isRented;
	/** 대여 가격*/
	private int rentFee;
	
	public ComicsBook(String name, boolean isRented, int rentFee) {
		this.name = name;
		this.isRented = isRented;
		this.rentFee = rentFee;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getIsRented() {
		return this.isRented;
	}

	public int getRentFee() {
		return this.rentFee;
	}
	
	public void rent() {
		this.isRented = true;
	}
	
	public void returnBook() {
		this.isRented = false;
	}

}
