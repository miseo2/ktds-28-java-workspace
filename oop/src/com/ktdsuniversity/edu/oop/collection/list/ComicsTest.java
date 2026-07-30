package com.ktdsuniversity.edu.oop.collection.list;

import com.ktdsuniversity.edu.oop.cafe.ComicsBook;

public class ComicsTest {

	public static void main(String[] args) {
		ComicsBookCafe cafe = new ComicsBookCafe();
		cafe.addBook(new ComicsBook("만화책 1권", false, 600));
	}
}
