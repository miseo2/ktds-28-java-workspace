package string;

public class ToLowerCase {
	public String solution(String myString) {
		String answer = "";
		answer = myString.toLowerCase();
		return answer;
	}
	
	public static void main(String[] args) {
		
		ToLowerCase tlc = new ToLowerCase();
		String str = tlc.solution("AACd");
		System.out.println(str);
	}

}
