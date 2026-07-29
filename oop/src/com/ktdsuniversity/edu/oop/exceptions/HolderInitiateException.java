package com.ktdsuniversity.edu.oop.exceptions;
/**
 * GoodsHolder의 생성자에 잘못된 값을 전달했을때 발생하는 예외다.
 */


// 노란줄이 생기는 이유는 RuntimeException안에 있는 거 때문에 노란줄이 생김
// Serializable serialVersionUID가 없어서 생기는 문제 
// serialVersionUID 이걸 가지고 복제를 했을때 복사본가 비교가가능해짐
public class HolderInitiateException extends RuntimeException {

	
	private static final long serialVersionUID = -4766163612547661107L;
	
	public HolderInitiateException(String message) {
		super(message);
	}

}
