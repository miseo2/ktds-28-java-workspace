package homework.lotto;

import java.util.ArrayList;
import java.util.List;

public class ListLotto {
	
	public void main(String[] args) {
		
		List<Integer> lottoNumbers = new ArrayList<>();
		
		while (lottoNumbers.size() < 6) {
			
			int number = (int) (Math.random() * 45) + 1;
			
			if (!lottoNumbers.contains(number)) {
                lottoNumbers.add(number);
            }
		}
		
		System.out.println(lottoNumbers);
		
	}

}
