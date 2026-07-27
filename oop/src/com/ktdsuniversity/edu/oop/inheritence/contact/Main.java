package com.ktdsuniversity.edu.oop.inheritence.contact;

public class Main {
	
	// 모든 연락처들의 이름과 전화번호를 출력해라.
	public static void printNameAndPhone(Contact contact) {
		System.out.println(contact.getName());
		System.out.println(contact.getPhone());
	}
	
	public static void main(String[] args) {
		
		Contact contact = new Contact("친구1", "010-0000-0000");
		printNameAndPhone(contact);
		
		contact.printContact();
		
		EmailContact contact2 = new EmailContact("친구2", "010-0000-0000", "test@email,com");
		printNameAndPhone(contact2);
		
		
		
		String email = contact2.getEmail();
		System.out.println(email);
		contact2.printContact();
		
		
	}

}
