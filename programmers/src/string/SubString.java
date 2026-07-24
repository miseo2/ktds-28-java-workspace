package string;

public class SubString {
	public int solution(String str1, String str2) {
		int answer = 0;
		if (str2.length() <= 20 && str1.length() <= str2.length() && str1.length() >= 1) {
			if (str2.contains(str1)) {
				answer = 1;
			} 
		} else {
			answer = 0;
		}
		return answer;
	}

}
