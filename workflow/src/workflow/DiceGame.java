package workflow;

public class DiceGame {
	
	public static void main(String[] args) {
		/*
		 * 주사위를 굴려 최종 목적지에 먼저 도착하는 플레이어가 승리하는 게임
		 * 
		 * 위치값을 가진 4명의 플레이거가 있습니다.
		 * 모든플레이어의 위치값은 0부터 시작합니다.
		 * 
		 * 각 플레이어들은 주사위 두 개를 굴려 나온 수만큼 이동을 합니다.
		 * 도착지의 위치값은 127입니다.
		 * 
		 * ===== 주사위 규칙 =====
		 * 1. 두 개의 주사위를 굴린 값이 3,7 이라면 위치 값은 10만큼 증가합니다.
		 * 2. 두 주사위가 똑같은 숫자가 나온다면 주사위 합의 배수만큼 이동합니다.
		 *  -> 4, 4 => 8 * 2 ==> 16
		 * 3. 두 주사위값의 합이 3의 배수일 경우 위치값은 합의 수 만큼 감소합니다.
		 * -> 4,5 ==> 9 ==> -9\
		 * 
		 * 플레이어의 위치 값은 0보다 작아질 수 없습니다.
		 * 현재 위치값이 8이고, 이동할 칸의 수가 -9라면 위치 값은 0이 되어야합니다.
		 * 
		 * 플레이어가 주사위를 굴릴 때마다 주사위의 값, 이동할 칸의 수, 현재 위치값을 표시합니다.
		 */
		int playerA = 0;
		int playerB = 0;
		int playerC = 0;
		int playerD = 0;
		
		final int GOAL_POSITION = 127;
		
		while (playerA < 127 && playerB < 127 && playerC < 127 && playerD < 127) {
			double randomNumber = Math.random();
			//playerA
			int diceA = (int)(randomNumber * 6 + 1);
			int diceB = (int)(randomNumber * 6 + 1);
			int sumDice = diceA + diceB;
			
			if (sumDice % 3 == 0) {
				playerA -= sumDice;
				if (playerA < 0) {
					playerA = 0;
				}
			}else if (diceA == diceB) {
				playerA += sumDice * 2;
			}else {
				playerA += sumDice;
			}
			
			//playerB
			diceA = (int)(randomNumber * 6 + 1);
			diceB = (int)(randomNumber * 6 + 1);
			sumDice = diceA + diceB;
			
			if (sumDice % 3 == 0) {
				playerB -= sumDice;
				if (playerB < 0) {
					playerB = 0;
				}
			}else if (diceA == diceB) {
				playerB += sumDice * 2;
			}else {
				playerB += sumDice;
			}
			
			//playerC
			diceA = (int)(randomNumber * 6 + 1);
			diceB = (int)(randomNumber * 6 + 1);
			sumDice = diceA + diceB;
			
			if (sumDice % 3 == 0) {
				playerB -= sumDice;
				if (playerB < 0) {
					playerB = 0;
				}
			}else if (diceA == diceB) {
				playerB += sumDice * 2;
			}else {
				playerB += sumDice;
			}
			
			//playerD
			diceA = (int)(randomNumber * 6 + 1);
			diceB = (int)(randomNumber * 6 + 1);
			sumDice = diceA + diceB;
			
			if (sumDice % 3 == 0) {
				playerB -= sumDice;
				if (playerB < 0) {
					playerB = 0;
				}
			}else if (diceA == diceB) {
				playerB += sumDice * 2;
			}else {
				playerB += sumDice;
			}
		}
	}

}
