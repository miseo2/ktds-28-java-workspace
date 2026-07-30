package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.exceptions.Goods;

public class ListExam {
	
	public static void main(String[] args) {
		
		// 정수를 관리하는 리스트 생성
		//java.utill.List
		//java.util.ArrayList
		//Crtl + Shift + o
		List<Integer> decimalList = new ArrayList<>();
		
		//리스트에 몇 개의 정수가 있나?
		int size = decimalList.size();
		System.out.println(size); //0
		
		//리스트에 정수 하나를 추가
		//메모리가 허용하는한 마음대로 추가 가능하다.
		decimalList.add(1200); // 0 index
		decimalList.add(2400); // 1 index
		
		//리스트에 몇 개의 정수가 있나?
		size = decimalList.size();
		System.out.println(size); //2
		
		// 리스트의 0번 인덱스의 값을 가져온다.
		int value0 = decimalList.get(0);
		System.out.println(value0);
		
		//리스트의 1번 인덱스의 값을 가져온다.
		int value1 = decimalList.get(1);
		System.out.println(value1);
		
		//리스트의 2번 인덱스의 값을 가져온다.
		if (decimalList.size() >2) {
			int value2 = decimalList.get(2);
			System.out.println(value2);
		}
		
		//리스트의 0번 인덱스를 삭제한다. (인덱스 자체를 제거한다.)
		//리스트의 0번 인덱스를 삭제하고, 해당 인덱스에 있던 값을 반환시킨다.
		int removeValue =decimalList.remove(0);
		System.out.println(removeValue + " 삭제됨.");
		
		//삭제한 이후의 리스트 개수를 출력해본다.
		size = decimalList.size();
		System.out.println(decimalList.size() + "개의 개수가 있다");
		
		//리스트의 1번 인덱스를 가져온다.
//		value1 = decimalList.get(1);
//		System.out.println(value1); //IndexOutBoundsException 발생
		
		//리스트에 10개의 랜덤 값을 추가 한다.
		decimalList.add((int) (Math.random() *1000));
		decimalList.add((int) (Math.random() *1000));
		decimalList.add((int) (Math.random() *1000));
		decimalList.add((int) (Math.random() *1000));
		decimalList.add((int) (Math.random() *1000));
		decimalList.add((int) (Math.random() *1000));
		decimalList.add((int) (Math.random() *1000));
		decimalList.add((int) (Math.random() *1000));
		decimalList.add((int) (Math.random() *1000));
		decimalList.add((int) (Math.random() *1000));
		decimalList.add((int) (Math.random() *1000));
		
		System.out.println(decimalList.size() + "개 정수가 있음");
		
		// 리스트에 있는 모든 데이터를 지워라
		decimalList.clear();
		
		System.out.println(decimalList.size() + "개 정수가 있음.");
		
		// 리스트에 100, 200, 300, 400, 500, 600 숫자를 순서대로 할당한다.
		decimalList.add(100);
		decimalList.add(200);
		decimalList.add(300);
		decimalList.add(400);
		decimalList.add(500);
		decimalList.add(600);
		
		// 리스트에 100이 존재하는라?
		if (decimalList.contains(100)) {
			System.out.println("100이 존재 합니다.");
		}
		// 리스트에 200이 존재하는가?
		if (decimalList.contains(200)) {
			System.out.println("200이 존재 합니다.");
		}
		// 리스트에 305가 존재하는가?
		if (!decimalList.contains(305)) {
			System.out.println("305가 존재하지 않습니다.");
		}
		
		//리스트에 들어있는 모든 항목을 출력한다.
		System.out.println(decimalList);
		
		for (int i = 0; i < decimalList.size(); i++) {
			System.out.println(i + " 번째 숫자 => " + decimalList.get(i));
		}
		
		Goods newGoods = new Goods("상품1", 500);
		Goods otherGoods = new Goods("상품1", 500);
		// 레퍼런스는 메모리주소가 같은지를 확인
		System.out.println(newGoods == otherGoods);
		
		System.out.println("goods equals" + newGoods.equals(otherGoods));
		
		//otherGoods의 메모리 주소를 가진다
		Goods cloneGoods = otherGoods;
		System.out.println(cloneGoods == newGoods); // False
		System.out.println(cloneGoods == otherGoods); // true
		
		int n1 = 100;
		int n2 = 100;
		
		// 프리미티브는 값이 같은지를 확인
		System.out.println(n1 == n2);

		List<Goods> goodsList = new ArrayList<>();
		
		// goodsList에 Goods 인스턴스를 추가한다.
		// goodsList에 Goods 인스턴스를 추가한다
		// goodsList에 Goods 인스턴스를 추가한다
		goodsList.add(new Goods("1",100));
		goodsList.add(new Goods("2",200));
		goodsList.add(new Goods("3",300));
		// goodsList의 0번째 인덱스에 있는 Goods 인스턴스를 가져와 출력한다.
		// goodsList의 1번째 인덱스에 있는 Goods 인스턴스를 가져와 출력한다.
		// goodsList의 2번째 인덱스에 있는 Goods 인스턴스를 가져와 출력한다.
		Goods goods1 = goodsList.get(0);
		Goods goods2 = goodsList.get(1);
		Goods goods3 = goodsList.get(2);
		System.out.println(goods1.getName());
		System.out.println(goods2.getName());
		System.out.println(goods3.getName());
		
		// goodsList의 모든 Good 인스턴스를 출력한다. (for 이용)
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.println(goodsList.get(i));
		}
		
		// goodsList에서 상품의 이름이 "상품1" 이고 가격이 500인 상품이 존재하는가?
		boolean haveGoods = goodsList.contains(new Goods("2",200));
		System.out.println(haveGoods);
	}

}
