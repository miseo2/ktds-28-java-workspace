package com.ktdsuniversity.edu.oop.exam;

public class CraneGameMachine {
	
	boolean isInsertCoin;
	int dolls;
	
	public void insertCoin() {
		isInsertCoin = dolls > 0;
		
		if (dolls <= 0) {
			isInsertCoin = false;
		} else {
			isInsertCoin = true;
		}
	}
	
	public int doGame() {
		while (isInsertCoin) {
			int dollsStatus = (int) (Math.random()*2);
			if (dollsStatus == 0) {
				return 0;
			} else {
				dolls -= 1;
				isInsertCoin = false;
				return 1;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
//		int dollsStatus = (int) (Math.random()*2);

		CraneGameMachine dolls = new CraneGameMachine();
		dolls.dolls = 10;
		dolls.insertCoin();
		
		int result = dolls.doGame();
		
		System.out.println(dolls.dolls);
		System.out.println(result);
		
	}

}
