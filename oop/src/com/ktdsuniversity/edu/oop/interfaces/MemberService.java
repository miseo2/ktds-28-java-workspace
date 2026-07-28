package com.ktdsuniversity.edu.oop.interfaces;
/**
 * 회원을 관리할 수 있는 인터페이스
 */
public interface MemberService {
	
	/**회원 가입*/
	void join();
	
	/**회원 로그인*/
	void login();
	
	/**회원 탈퇴*/
	void deleteMe();
	
	/**회원 로그아웃*/
	void logout();
	

}
