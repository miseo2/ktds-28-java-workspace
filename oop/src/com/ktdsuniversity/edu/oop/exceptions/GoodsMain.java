package com.ktdsuniversity.edu.oop.exceptions;

public class GoodsMain {
	
	public static void main(String[] args) {
		GoodsHolder capsuleHolder = null;
		while(capsuleHolder == null) {
			int randomCount = (int) (Math.random() *1000) - 300;
			capsuleHolder = new GoodsHolder(randomCount);
			try {
				capsuleHolder = new GoodsHolder(randomCount);
			} catch (HolderInitiateException hie) {
				System.out.println(hie.getMessage());
			}
		}
		
		GoodsHolder capsuleholder = new GoodsHolder(-1);
		capsuleholder.addGoods("네스프레소 솔티드 캬라멜 커피", "8_900"); // 0
		capsuleholder.addGoods("네스프레소 카페라떼", null);			// 1
		capsuleholder.addGoods("돌체구스토 아메리카노", "팔천구백원");			// 2
		capsuleholder.addGoods("카누 에스프레소", "3_000_000_000");				// 3
		capsuleholder.addGoods("일리 에스프레소", "7_900");				// 4
		
		capsuleholder.printGoods();
		
		capsuleholder.printGoodsAt(-1);
		capsuleholder.printGoodsAt(0);
		capsuleholder.printGoodsAt(1);
		capsuleholder.printGoodsAt(2);
		capsuleholder.printGoodsAt(3);
		capsuleholder.printGoodsAt(99);
		
		capsuleholder.removeGoods(0);
		capsuleholder.removeGoods(1);
		capsuleholder.removeGoods(2);
		capsuleholder.removeGoods(3);
		capsuleholder.removeGoods(-1);
		capsuleholder.removeGoods(99);
		
		capsuleholder.printGoods();
		
	}

}
