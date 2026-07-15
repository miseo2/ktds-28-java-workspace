package workflow;

public class Battle {
	public static void main(String[] args) {
		/*
		 * BOSS 와 Player가 전투를 합니다.
		 * BOSS의 체력과 Player의 체력 중 하나라도 0이하가 된다면 게임은 종료 됩니다.
		 * 
		 * BOSS가 Player에게 공격을 합니다. (데미지는 랜덤한 정수 값)
		 * Player가 BOSS에게 공격을 합니다. (데미지는 랜덤한 정수 값)
		 * 
		 * 공격이 끝난 이후 서로의 체력을 출력합니다.
		 */
		int boss = 100; // BOSS의 체력
		int player = 100; // Player의 체력
		
		
//		while(boss == 0) {
//			// BOSS의 랜덤 공격력
//			double bossRandomDamage = Math.random();
//			int bossAttack = (int) (bossRandomDamage * 100);
//			
//			// Boss 공격
//			player -= bossAttack;
//			System.out.println(player);
//			
//			// Player의 랜덤 공격력
//			double playerRandomDamage = Math.random();
//			int playerAttack = (int) (playerRandomDamage * 100);
//			
//			//Player 공격
//			boss -= playerAttack;
//			System.out.println(boss);
			
			//================================
			int bossHitPoint = 1_000;
			int playerHitPoint = 800;
			while (bossHitPoint > 0 && playerHitPoint > 0) {
				double randomDamage = Math.random();
				int bossDamage = (int) (randomDamage * 200);
				playerHitPoint -= bossDamage;
				
				randomDamage = Math.random();
				int playerDamage = (int) (randomDamage * 250);
				bossHitPoint -= playerDamage;
				
				System.out.println("Player의 체력");
				System.out.println(playerHitPoint);
				
				System.out.println("Boss의 체력");
				System.out.println(bossHitPoint);
				System.out.println("==========");
				
//			}
		}
	}

}
