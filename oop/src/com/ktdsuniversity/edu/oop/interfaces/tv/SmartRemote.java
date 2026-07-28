package com.ktdsuniversity.edu.oop.interfaces.tv;

public class SmartRemote implements Remote {

	@Override
	public void turnOn(TV tv) {
		tv.turnOn();
	}

	@Override
	public void turnOff(TV tv) {
		tv.turnOff();
	}

	@Override
	public void increaseVolume(TV tv) {
		tv.increaseVolume();
	}

	@Override
	public void decreaseVolume(TV tv) {
		tv.decreaseVolume();
	}

	@Override
	public void increaseChannel(TV tv) {
		tv.increaseChannel();
	}

	@Override
	public void decreaseChannel(TV tv) {
		tv.decreaseChannel();
	}

	@Override
	public void changeInputSource(TV tv) {
		tv.changeInputSource();
	}

	@Override
	public void runApps(TV tv) {
		tv.runApps();
	}

	@Override
	public void runAI(TV tv) {
		System.out.println("이 TV에는 AI기능이 존재하지 않습니다.");
	}

	@Override
	public void controlShoppingButtons(TV tv) {
		System.out.println("이 TV에는 홈ㅅ핑기능이 존재하지 않습니다.");
	}

	@Override
	public void inputChannelNumber(int number/*11*/, TV tv) {
		tv.changeChannel(number);
	}

	@Override
	public void mute(TV tv/*volumn = 0*/) {
		tv.mute();
	}

	@Override
	public void changeTvSettings(TV tv) {
		System.out.println("이 TV의 설정 정보가 존재하지 않습니다.");
	}

}
