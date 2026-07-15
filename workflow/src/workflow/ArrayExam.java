package workflow;

public class ArrayExam {
	public static void main(String[] args) {
		
		// longText 문자열 변수에 's' 가 몇 개 있는지 세어보기
		String longText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since 1966, when designers at Letraset and James Mosley, the librarian at St Bride Printing Library in London, took a 1914 Cicero translation and scrambled it to make dummy text for Letraset's Body Type sheets. It has survived not only many decades, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised thanks to these sheets and more recently with desktop publishing software like Aldus PageMaker and Microsoft Word including versions of Lorem Ipsum.";
		char[] letters = longText.toCharArray();
		
		// character는 홑따옴표('')로 작성
		// 'a', 's', ....
		
		//s의 갯수
		int s = 0;
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == 's') {
				s += 1;
			}
		}
		System.out.println("s는 " + s + "개 입니다.");
	}

}
