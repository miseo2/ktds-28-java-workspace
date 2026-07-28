package com.ktdsuniversity.edu.oop.interfaces.tv;


public interface TV {
	
	//                    0     1    2    3     4
	String[] CHANNELS = {"5", "7", "9", "11", "13"};
	
	void turnOn();
	void turnOff();
	
	void increaseVolume();
	void decreaseVolume();
	
	void increaseChannel();
	void decreaseChannel();
	
	void changeInputSource();
	
	void readUsb();
	
	void runApps();
	
	void mute();
	
	void changeChannel(int channelNumber);
	

}
