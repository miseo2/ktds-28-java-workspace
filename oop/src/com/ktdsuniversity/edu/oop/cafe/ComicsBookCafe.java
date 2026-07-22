package com.ktdsuniversity.edu.oop.cafe;

public class ComicsBookCafe {
	
	/** 만화 카페가 가지고 있는 책들*/
	private ComicsBook[] books;
	
	/** 만화 카페 소지금*/
	private int take;
	
	public ComicsBookCafe(ComicsBook[] books) {
		this.books = books;
	}
	
	public void displayBooks() {
		System.out.println(" ==== 만화책 목록 === ");
		for (int i = 0; i < this.books.length; i++) {
			
			ComicsBook book = this.books[i];
			
			String state = "대여 가능";
			if (book.getIsRented()) {
				state = "대여 중";
			}
			
			System.out.println("만화책 번호: " + i);
			System.out.println("만화책 이름: " + book.getName());
			System.out.println("만화책 대여 상태: " + state);
			System.out.println("만화책 대여비: " + book.getRentFee());
		}
	}
	
	public void takeRentFee(int fee) {
		this.take += fee;
	}
	
	public ComicsBook[] getBooks() {
		return this.books;
	}

}
