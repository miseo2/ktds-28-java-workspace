package homework.lotto;

public class ArrayLotto {
	
	public static void main(String[] args) {
		
		int[] lottoNumbers = new int[6];
		
		int number = 0;
		
		for (int i = 0; i < lottoNumbers.length; i++) {
			// 중복검사
			while(true) {
				//랜덤 숫자 뽑기 1 ~ 45 
				number = (int) (Math.random() * 45) + 1;
				
				 // 중복 확인
                boolean duplicate = false;

                for (int j = 0; j < i; j++) {

                    if (lottoNumbers[j] == number) {
                        duplicate = true;
                        break;
                    }
                }

                // 중복이 아니면 반복 종료
                if (!duplicate) {
                    break;
                }
            }

            lottoNumbers[i] = number;
        }
		
		// 로또 번호 출력
		System.out.print("로또번호: ");
        for (int i = 0; i < lottoNumbers.length; i++) {
            System.out.print(lottoNumbers[i] + " ");
        }
	}	
}


