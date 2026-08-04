package com.ktdsuniversity.edu.oop.enums;

public enum CalcType {
	//이름만 존재하는 상수
	ADD("덧셈"), SUB("뺄셈"), MUL("곱셈"), DIV("나눗셈");
	
	private String name;
	
	CalcType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
