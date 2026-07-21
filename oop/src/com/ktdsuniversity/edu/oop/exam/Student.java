package com.ktdsuniversity.edu.oop.exam;

public class Student {
	int java;
	int python;
	int cpp;
	int csharp;
	
	public Student(int java, int python, int cpp, int csharp) {
		this.java = java;
		this.python = python;
		this.cpp = cpp;
		this.csharp = csharp;
	}
	
	public int getSumAllScores() {
		return java + python + cpp + csharp;
	}
	
	public double getAverage(int sum) {
		return (double) sum / 4;
	}
	
	public double getCourseCredit(double average ) {
		if (average < 55) {
			return 0.1;
		}
		return (average - 55) / 10;
	}
	
	public String getABCDE(double courseCredit) {
		if (courseCredit >= 4.1) {
			return "A+";
		} else if (courseCredit >= 3.6) {
			return "A";
		} else if (courseCredit >= 3.1) {
			return "B+";
		} else if (courseCredit >= 2.6) {
			return "B";
		} else if (courseCredit >= 1.6) {
			return "C";
		} else if (courseCredit >= 0.6) {
			return "D";
		} else {
			return "F";
		}
	}
	public static void main(String[] args) {
		// 							  java, py, cpp, cs
		Student student = new Student(100, 80, 75, 95);
//		student.java = 100;
//		student.python = 80;
//		student.cpp = 75;
//		student.csharp = 95;
		Student park = new Student (90, 30, 50, 20);
		
		int sum = student.getSumAllScores();
		double average = student.getAverage(sum);
		double courseCredit = student.getCourseCredit(average);
		String score = student.getABCDE(courseCredit);
		
		System.out.println(sum);
		System.out.println(average);
		System.out.println(courseCredit);
		System.out.println(score);
		
		
		
	}

}
