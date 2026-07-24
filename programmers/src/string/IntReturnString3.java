package string;

public class IntReturnString3 {
	
	public String solution(int n) {
		String answer = "";
		if(n <= 10000 && n >= 1) {
			// Int 타입 정수를 문자열로 바꿔주는 String method
			answer = String.valueOf(n); 
		}
		return answer;
	}

}
