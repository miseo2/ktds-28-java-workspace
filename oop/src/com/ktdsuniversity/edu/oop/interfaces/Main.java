package com.ktdsuniversity.edu.oop.interfaces;

public class Main {
	
	public static void main(String[] args) {
		
		// ArticleSystem is a ArticleService
		ArticleService articleService = new ArticleSystem();
		articleService.write();
		articleService.delete();
		articleService.view();
		
		// ArticleSystem is a ReplyService
		ReplyService replyService = new ArticleSystem();
		replyService.addReply();
		replyService.deleteReply();
		replyService.recommendReply();
		
		// MemberService, VipMemberService의 인스턴스 생성.
		// VipMemberService is a MemberService
		// Member is a MemberService
		MemberService member = new Member();
		member.deleteMe();
		member.join();
		member.login();
		member.logout();
		// Vipmember is a VipMemberService 
		VipMemberService vip = new VipMember();
		vip.join();
		vip.deleteMe();
		vip.login();
		vip.logout();
		vip.addPoint(30);
		// VipMember is MemberService
		MemberService vip1 = new VipMember();
		vip1.deleteMe();
		vip1.join();
		vip1.login();
		vip1.logout();
		// addpoint는 사용하지 못함
		// 사용하고 싶다면 instanceof를 사용하면 사용가능
		// memberservice를 뒤집어 쓰고 있지만 안에 알맹이가 vipmemberservice라면
		// vip addpoint를 쓸 수 있다
		if (vip1 instanceof VipMemberService vipmem) {
			vipmem.addPoint(100);
		}
		// SomeInterface의 인스턴스를 생성해보기
		// Interface는 인스턴스로 생성 할 수 없다.
		// ==> Java의 인스턴스는 모든 메소드가 구현이 되어있어야한다.
		SomeInterface inf = new SomeClass2();
		inf.doSomething1();
		inf.doSomething2();
		inf.doSomething3();
		
		int value = inf.getSomething();
		System.out.println(value);
		
		String str = inf.getString();
		System.out.println(str);
	}

}
