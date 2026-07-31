package com.ktdsuniversity.edu.oop.collection.list;

public class GoodsMain {
	
	public static void main(String[] args) {
		GoodsHolder holder = new GoodsHolder();
		holder.printGoods();
		
		holder.addGoods("화장품", 70000, true);
		holder.addGoods("샤프", 2500, true);
		holder.addGoods("로션", 7000, true);
		

	}

}
