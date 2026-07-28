package com.ktdsuniversity.edu.oop.interfaces;

public class Member implements MemberService{

	@Override
	public void join() {
		System.out.println("회원가입 완료");
		
	}

	@Override
	public void login() {
		System.out.println("로그인 완료");
		
	}

	@Override
	public void deleteMe() {
		System.out.println("회원탈퇴 완료");
		
	}

	@Override
	public void logout() {
		System.out.println("로그아웃 완료");
		
	}
	
}
