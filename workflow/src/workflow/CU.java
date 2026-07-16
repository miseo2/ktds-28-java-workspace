package workflow;

public class CU {
	
	public static void main(String[] args) {
		//편의점.draw.io 파일을 토대로 작성한 코드
		
		/*
		 * 시작.
		 * 손님이 바구니에 담아온 상품의 가격 정보.
		 */
		// 손님이 바구니에 담아온 상품의 가격 정보
		int[] items = new int[5];
		items[0] = 5000;
		items[1] = 1800;
		items[2] = 3200;
		items[3] = 30000;
		items[4] = 1300;
		
		// 손님이 바구니에 담아온 상품의 할인 정보
		float[] dc = new float[5];
		dc[0] = 0;
		dc[1] = 0.1f; // 1800원 상품을 10% 할인.
		dc[2] = 0.2f; // 3200원 상품을 20% 할인.
		dc[3] = 1; // 30000원 상품을 100% 할인.
		dc[4] = 0;
		
		// 봉투가격
		final int BAG_PRICE = 100;
		// 한 봉투에 넣을 수 있는 상품의 수
		final int SPLIT_COUNT = 2;
		
		// 고객의 자금 상황
		final int CARD_LIMIT = 1_000_000;
		// 현재까지 사용한 카드 결제 금액
		int cardPaidMoney = 150_000;
		
		// 체크 카드 계좌 잔액
		int remainAccount = 4000;
		
		// 보유한 현금
		int cash = 30_000;
		
		// 보유한 포인트
		int point = 1_750;
		
		// 최종 결제 금액
		int amount = 0;
		// TODO 손님이 가져온 상품 목록의 결제 금액 계산해서 amount에 할당
		// 할인율 계산 필요
		for (int i =0; i < items.length; i++) {
			// 상품의 할인이 없다면 상품의 가격을 amount에 더해라
			if (dc[i] == 0) {
				amount += items[i];
			}
			// 상품의 할인이 있다면 할인율을 뺀 가격을 amount에 더해라
			else {
				amount += items[i] * (1 - dc[i]);
			}
		}
		// 총 상품의 수량
		int itemCount = items.length;
		System.out.println("총 상품의 수 : " + itemCount +"개");
		
		// 봉투 가격
		// 봉투 필요여부 (0 ==> 필요, 1 ==> 필요없음)
		int needBag = (int) (Math.random() * 2);
		if (needBag == 0) {
			int bagCount = items.length / SPLIT_COUNT;
			// 봉투에 넣고 남은 상품이 더 남았다면
			if (items.length % SPLIT_COUNT > 0) {
				bagCount++;
			}
//			int bagCount = (int) Math.ceil(items.length / (double) SPLIT_COUNT);
			// 위에 코드 대신 주석된 코드로 한줄로도 정의가능
			amount += bagCount * BAG_PRICE;
			System.out.println("봉투 " + bagCount + "개 구입");
			System.out.println("봉투가격 : " + bagCount * BAG_PRICE + "원");
		}
		System.out.println("총 결제금액 : " + amount + "원");
		System.out.println("결제를 시작합니다.");
		// 결제 수단 선택 (0 ==> 현금, 1 ==> 신용카드 2 ==> 체크카드, 3 ==> 포인트 선결제, 4 ==> 포기)
//		int payment = (int) (Math.random() * 5);
		// TODO 결제 수단 선택
		// 신용카드 & 결제금액 5만원 이상일 경우 할부 또는 일시불 선택
		
		// TODO 현금으로 결제했을 때, 보유한 현금을 최종 결제 금액만큼 차감.
		// TODO 신용카드로 결제했을 때, 카드 결제금액을 최종 결제 금액만큼 증가.
		// TODO 포인트 선결제 했을때 포인트를 최종 결제 금액만큼 차감.
		boolean paymentCompleted = false;
		while (! paymentCompleted) {
			int payment = (int) (Math.random() * 5);
			if (payment == 0) {
				System.out.println("현금결제 선택");
				//현금일때 최종결제금액보다 보유한 현금이 많다면
				if (cash >= amount) {
					cash -= amount;
					paymentCompleted = true;
					System.out.println("현금결제를 완료하였습니다.");
				} else {
					System.out.println("현금 잔액이 부족합니다.");
				}
			} else if (payment == 1) {
				// 신용카드일때
			} else if (payment == 2) {
				System.out.println("체크카드결제 선택");
				// 체크카드일때
				if (remainAccount >= 0) {
					remainAccount -= amount;
					paymentCompleted = true;
					System.out.println("체크카드결제를 완료하였습니다.");
				} else {
					System.out.println("카드 잔액이 부족합니다.");
				}
			} else if (payment == 3) {
				// 포인트 선 결제
			} else if (payment == 4) {
				// 결제 취소
				System.out.println("결제를 취소합니다.");
				break;
			}
		}
 		// 포인트 적립 (0 ==> 적립 1 ==> 적립안한다)
		int addPoint = (int) (Math.random()*2);
		
		// TODO 적립을 할 경우 (addPoint == 0) 이라면 총 결제금액에서 10% 적립.
		if (addPoint == 0) {
			point += (int) (amount * 0.1f);
			System.out.println(point);
		}
	}

}
