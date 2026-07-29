package com.ktdsuniversity.edu.oop.exceptions;

public class GoodsHolder {
	
	private Goods[] goods;
	private int goodsIndex;
	
	public GoodsHolder(int goodsCount) {
		if (goodsCount < 0) {
			HolderInitiateException hie = 
					new HolderInitiateException("잘못된 인덱스 개수입니다. 0보다 큰 값을 입력하세요.");
			throw hie;
		}
		this.goods = new Goods[goodsCount];
	}
	
	public void addGoods(String name, String price) {
		if (price == null) {
			return;
		}
		
		//팔천구백원  -> ""
		price = price.replaceAll("[^0-9]","");
		if (price.isBlank()) {
			return;
		}
//		int temPrice = Integer.parseInt(price);
		long temPrice = Long.parseLong(price);
		if (temPrice > Integer.MAX_VALUE || temPrice <Integer.MIN_VALUE) {
			return;
		} 
		int intPrice = (int) temPrice;
		
		
		this.addGoods(name, intPrice);
	}
	
	public void addGoods(String name, int price) {
		if (name == null || name.isBlank()) {
			return;
		}
		
		if (this.goodsIndex < this.goods.length) {
			this.goods[this.goodsIndex++] = new Goods(name, price);
			
		}
	}
	
	public void removeGoods(int goodsIndex) {
		if (goodsIndex >= 0 && goodsIndex < this.goods.length) {
			this.goods[goodsIndex] = null;
		}
	}
	
	public void printGoodsAt(int index) {
		Goods goods = null;
		
		if (index < this.goods.length && index >= 0) {
			goods = this.goods[index];
		}
		
		if (goods != null ) {
			String message = "%d. %s(%d)".formatted(index + 1, goods.getName(), goods.getPrice());
			System.out.println(message);
		}
	}
		

	
	public void printGoods() {
		for (int i = 0; i < this.goods.length; i++) {
			this.printGoodsAt(i);
		}
	}

}
