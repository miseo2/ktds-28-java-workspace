package array;

public class P181941 {
	public String solution(String[] arr) {
		String answer = "";
		for(int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String[] array = new String[1];
		array[0] = "ac";
		array[1] = "b";
		P181941 p = new P181941();
		p.solution(array);
	}

}
