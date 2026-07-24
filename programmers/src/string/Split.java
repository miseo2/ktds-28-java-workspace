package string;

public class Split {
	public int solution(String num_str) {
		int answer = 0;
		String[] str = num_str.split("");
		for(int i = 0; i <= str.length ; i++) {
			//str[i]를 정수로 만들어준다.
			answer += Integer.parseInt(str[i]);
			
		}
		

		return answer;
	}
	
	public static void main(String[] args) {
		Split split = new Split();
		split.solution("123");
	}

}
