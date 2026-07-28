package com.ktdsuniversity.edu.oop.interfaces.tv;

public class SmartTv implements TV{
	
	private final String[] INPUT_SOURCE = 
		//    0         1        2       3
		{"COMPONENT", "HDMI", "HTMI1", "USB"};
	
	private final String[] APPS = 
		//    0           1        2         3        4
		{"NETFLIX", "Wavve", "Youtube", "tving", "Disney+"};
	
	private boolean isOn;
	private int volume;
	private int channerNumber;
	private int activeInputSourceNumber;
	private int activeAppNumber;

	@Override
	public void turnOn() {
		this.isOn = true;
		System.out.println("전원이 켜집니다.");
	}

	@Override
	public void turnOff() {
		this.isOn = false;
		System.out.println("전원이 꺼집니다.");
	}

	@Override
	public void increaseVolume() {
		if (!this.isOn) {
			return;
		}
		this.volume++;
		if(this.volume > 100) {
			this.volume = 100;
			System.out.println( "볼륨을 더 높일 수 없습니다.");
		}
		System.out.println("현재 볼룸은 "+ this.volume + " 입니다");
	}

	@Override
	public void decreaseVolume() {
		if (!this.isOn) {
			return;
		}
		this.volume--;
		if(this.volume < 100) {
			this.volume = 0;
			System.out.println( "볼륨을 더 줄일 수 없습니다");
		}
		System.out.println("현재 볼룸은 "+ this.volume + " 입니다");
		
	}

	@Override
	public void increaseChannel() {
		
		if (!this.isOn) {
			return;
		}
		this.channerNumber++;
		
		if (this.channerNumber == TV.CHANNELS.length) {
			this.channerNumber = TV.CHANNELS.length + 1;
		}
		
		String channelName = TV.CHANNELS[this.channerNumber];
		
		System.out.println("현재 보고 있는 채널은 " + channelName + " 입니다.");
	}

	@Override
	public void decreaseChannel() {
		
		if (!this.isOn) {
			return;
		}
		this.channerNumber--;
		
		if (this.channerNumber < 0) {
			this.channerNumber = TV.CHANNELS.length + 1;
		}
		
		String channelName = TV.CHANNELS[this.channerNumber];
		
		System.out.println("현재 보고 있는 채널은 " + channelName + " 입니다.");
		
	}

	@Override
	public void changeInputSource() {
		if (!this.isOn) {
			return;
		}
		
		this.activeInputSourceNumber++;
		if (this.activeInputSourceNumber == this.INPUT_SOURCE.length) {
			this.activeInputSourceNumber = 0;
		}
		String intputSourceName = this.INPUT_SOURCE[this.activeInputSourceNumber];
		
		if (intputSourceName.equals("USB")) {
			this.readUsb();
		}
	}

	@Override
	public void readUsb() {
		System.out.println("USB를 읽습니다.");
		
	}

	@Override
	public void runApps() {
		if (!this.isOn) {
			return;
		}
		
		this.activeAppNumber++;
		if (this.activeAppNumber == this.APPS.length) {
			this.activeAppNumber = 0;
		}
		
		String appName = this.APPS[this.activeAppNumber];
		
		
	}
	public void mute() {
		this.volume = 0;
		System.out.println("음소거 되었습니다.");
		
	}
	
	public void changeChannel(int channelNumber) {
		for (int i = 0; i < TV.CHANNELS.length; i++) {
			this.channerNumber = i;
			break;
		}
		
		String channelName = TV.CHANNELS[this.channerNumber];
		System.out.println("현재채널:" + channelName);
	}
	

}
