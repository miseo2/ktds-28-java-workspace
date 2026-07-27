package com.ktdsuniversity.edu.oop.inheritence.contact;

public class EmailContact extends Contact {
	
	private String email;
	
	public EmailContact(String name, String phone, String email) {
		super(name, phone); // 나의 기본생성자를 호출해라
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
