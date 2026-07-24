package string;

public class SearchString {

	public int solution(String myString, String pat) {
		int answer = 0;
		myString = myString.toLowerCase();
		pat = pat.toLowerCase();
		if (myString.contains(pat)) {
			answer = 1;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		SearchString string = new SearchString();
		int result = string.solution("abcdefg", "cde");
		System.out.println(result);
	}

}
