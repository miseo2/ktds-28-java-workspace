package com.ktdsuniversity.edu.oop.datetime;

import java.time.LocalDate;
import java.util.List;

public class Talk {
	
	public static void main(String[] args) {
		Friends talk = new Friends();
		talk.addFriend(new Friend("친구1", LocalDate.parse("2000-01-01")));
		talk.addFriend(new Friend("친구2", LocalDate.parse("2000-02-01")));
		talk.addFriend(new Friend("친구3", LocalDate.parse("2000-03-01")));
		talk.addFriend(new Friend("친구4", LocalDate.parse("2000-04-01")));
		talk.addFriend(new Friend("친구5", LocalDate.parse("2000-05-01")));
		talk.addFriend(new Friend("친구6", LocalDate.parse("2000-07-01")));
		talk.addFriend(new Friend("친구7", LocalDate.parse("2000-08-01")));
		talk.addFriend(new Friend("친구8", LocalDate.parse("2000-08-02")));
		talk.addFriend(new Friend("친구9", LocalDate.parse("2000-08-03")));
		talk.addFriend(new Friend("친구10", LocalDate.parse("2000-08-04")));
		talk.addFriend(new Friend("친구11", LocalDate.parse("2000-08-05")));
		talk.addFriend(new Friend("친구12", LocalDate.parse("2000-08-06")));
		talk.addFriend(new Friend("친구13", LocalDate.parse("2000-08-07")));
		talk.addFriend(new Friend("친구14", LocalDate.parse("2000-08-08")));
		talk.addFriend(new Friend("친구15", LocalDate.parse("2000-08-09")));
		talk.addFriend(new Friend("친구16", LocalDate.parse("2000-08-10")));
		talk.addFriend(new Friend("친구17", LocalDate.parse("2000-08-11")));
		
		//오늘로 부터 3일 전후로 생일을 맞이했거나 한 친구 목록
		//2026-08-04 기준 2026-08-01 ~ 2026-08-07까지 생일인 친구들
		List<Friend> specialFriends = talk.findFriendsBy(3);
		
		for (int i = 0; i <specialFriends.size();i++) {
			System.out.println(specialFriends.get(i));
		}
	}

}
