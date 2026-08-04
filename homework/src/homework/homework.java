package homework;

public class homework {
	
	/*
	 * 1. 변수를 만드는 방법
	 * 자료형 변수명 = 값;
	 */
	int num = 10;
	String name = "이름";
	
	/*
	 * 2. 메소드를 만드는 방법
	 * 접근제한자 (예약어) 반환타입 메소드명 (파라미터타입, 파라미터명) {
	 *     메소드 호출시 실행할 코드;
	 *     return 값;
	 * }
	 */
	public void printHello() {
		System.out.println("안녕하세요");
	}
	
	public int numSum(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	
	/*
	 *  3. 메소드를 호출하는 방법
	 *  printHello();
	 *  numSum(10, 35);
	 */
	
	/*
	 *  4. 클래스를 만드는 방법
	 *  public class 클래스명 () {}
	 */
	
	/*
	 *  5. 클래스를 인스턴스로 만드는 방법
	 *  생성자를 호출해서 새로운 인스턴스로 만든다.
	 *  public class Car () {}
	 *  Car car = new Car();
	 */
	
	/*
	 *  6. 생성자를 만드는 방법
	 *  public class Car () {
	 *  	String name;
	 *  	String modelYear;
	 *  
	 *  	public Car(String name, String modelYear) {
	 *  		this.name = name;
	 *  		this.modelYear = modelYear;
	 *  	}
	 */
	
	/*
	 *  7. 생성자를 호출하는 방법
	 *  Car car = new Car("레이", "2018년");
	 *  
	 */
	
	/*
	 *  8. 변수와 인스턴스의 차이와 차이를 구분하는 방법.
	 *  변수 = 데이터가 할당된 메모리 주소의 이름
	 *  인스턴스 = 생성자로 만들어진 레퍼런스타입
	 *  
	 *  클래스를 변수로 사용하려면 인스턴스로 만들어야하고 
	 *  인스턴스가 만들어지면 변수에 할당을 해야 사용가능하다.
	 *  
	 *  Reference Type의 인스턴스는  특별한 . (점 연산자)를 사용할 수 있다.
	 *  
	 *  Car car = new Car("레이", "2018년");
	 *  new Car("레이", "2018년") - 인스턴스
	 *  car - new Car("레이", "2018년")인스턴스의 이름
	 */
	


}
