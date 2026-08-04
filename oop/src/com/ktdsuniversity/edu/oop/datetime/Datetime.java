package com.ktdsuniversity.edu.oop.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Datetime {
	
	public static void printNowDate() {
		LocalDate now = LocalDate.now();
		System.out.println(now);
	}
	
	public static void printNowTime() {
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
	}
	
	public static void printNowDateTime() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
	}
	
	public static void setAndPrintDate(int year, int month, int day) {
		LocalDate anniversaryDate = LocalDate.of(year, month, day);
		System.out.println(anniversaryDate);
	}
	
	public static void setAndPrintTime(int hour, int minute, int second) {
		LocalTime alarm = LocalTime.of(hour, minute, second);
		System.out.println(alarm);
	}
	
	public static void setAndPrintDateTime(
			int year, int month, int day, int hour, int minute, int second ) {
		LocalDateTime timeCapsule = LocalDateTime.of(year, month, day, hour, minute, second);
		System.out.println(timeCapsule);
	}
	
	public static void setAndPrintDate(String date) {
		LocalDate  anniversaryDate = LocalDate.parse(date);
		System.out.println(anniversaryDate);
	}
	
	public static void setAndPrintTime(String time) {
		LocalTime alarm = LocalTime.parse(time);
		System.out.println(alarm);
	}
	
	public static void setAndPrintDateTime(String DateTime) {
		LocalDateTime timeCapsule = LocalDateTime.parse(DateTime);
	}
	
	public static void printNowDateWithFormat() {
		LocalDate now = LocalDate.now();
		
		//formatter 지정.
		// y == 연도
		// M == 월
		// d == 일
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일");
		String dateString = now.format(format);
		System.out.println("변환 전: " + now);
		System.out.println("변환 후: " + dateString);
	}
	
	public static void printNowTimeWithFormat() {
		LocalTime now = LocalTime.now();
		
		// 시간 패턴
		// H: 시간(24시 기준)
		// h : 시간(12시간 기준)
		// m: 분 
		// s: 초
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		String timeString = now.format(format);
		
		System.out.println("변환 전: " + now);
		System.out.println("변환 후: " + timeString);
		
	}
	
	public static void printNowDateTimeWithFormat() {
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 EEEE HH시 mm분 ss초");
		String dateTimeString = now.format(format);
		
		System.out.println("변환 전: " + now);
		System.out.println("변환 후: " + dateTimeString);
	}
	
	public static void setAndPrintDateWithFormat(String date, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		LocalDate localDate = LocalDate.parse(date, formatter);
		System.out.println(localDate);
	}
	
	public static void setAndPrintTimeWithFormat(String time, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		LocalTime localTime = LocalTime.parse(time, formatter);
		System.out.println(localTime);
	}
	
	public static void setAndPrintDateTimeWithFormat(
			String dateTime, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
		System.out.println(localDateTime);
	}
	
	public static void plusYearAndPrintDateFromNow() {
		LocalDate now = LocalDate.now();
		//plus가 있으면 minus도 있지만 minus는 굳이 잘 안쓴다.
		LocalDate future = now.plusYears(7);
		System.out.println("7년 후 : "+ future);
	}
	
	public static void plusDaysAndPrintDateFromNow() {
		LocalDate now = LocalDate.now();
		
		LocalDate past = now.plusDays(-70);
		System.out.println("현재 : " + now);
		System.out.println("70일 전 : " + past);
	}
	
	public static void printPeriodFromTo(LocalDate from, LocalDate to) {
		Period period = Period.between(from, to);
		System.out.println(period);
		
		System.out.println("%s부터 %s까지 %d년 %d개월 %d일 지났습니다.".formatted(
							from, to, period.getYears(),period.getMonths(), period.getDays()));
	}
	
	public static void printBetweenDaysFromTo(LocalDate from, LocalDate to) {
		long days = ChronoUnit.DAYS.between(from, to);
		
		System.out.println("%s 부터 %s까지 %d일 지났습니다.".formatted(
				from,to,days));
	}
	
	public static void printIsAfter(LocalDate date) {
		// 현재날짜가 date보다 미래인지 확인해본다.
		LocalDate now = LocalDate.now();
		
		System.out.print("%s는 %s 보다".formatted(date,now));
		
		boolean isFuture = now.isAfter(date);
		if (isFuture) {
			System.out.println(" 미래입니다.");
		} else {
			System.out.println(" 과거입니다.");
		}
	}
	
	public static void printIsBefore(LocalDate date) {
		// 현재날짜가 date보다 과거인지 확인해본다.
		LocalDate now = LocalDate.now();
		System.out.println("%s는 %s 보다".formatted(date,now));
		
		boolean isPast = now.isBefore(date);
		if (isPast) {
			System.out.println(" 과거 입니다.");
		} else {
			System.out.println(" 미래 입니다.");
		}
	}
	
	public static void printIsToday(LocalDate date) {
		// 현재날짜가 date와 동일한지 확인해본다.
		LocalDate now = LocalDate.now();
		boolean isToday = now.isEqual(date);
		
		System.out.println("%s는".formatted(date));
		if (isToday) {
			System.out.println(" 오늘 입니다.");
		} else {
			System.out.println(" 오늘이 아닙니다.");
		}
	}
	
	public static void printChangeYears() {
		// 오늘 날짜에서 연도만 2012년으로 바꿔서 출력하기
		LocalDate now = LocalDate.now();
		
		now = now.withYear(2012);
		System.out.println(now);
	}
	
	
	public static void main(String[] args) {
		printNowDate();
		printNowTime();
		printNowDateTime();
		setAndPrintDate(2026, 2, 28);
		
		// 없는날짜는 나타낼 수 없다 java.time.DateTimeException
//		setAndPrintDate(2026, 2, 29);
		setAndPrintTime(9, 30, 11);
		setAndPrintTime(13, 8, 35);
		
		// 없는 시간은 출력하지 않는다. java.time.DateTimeException
//		setAndPrintTime(25, 1, 75);
		
		setAndPrintDateTime(2023,1, 13, 9, 48, 53);
		
		setAndPrintDate("2026-08-04");
		setAndPrintTime("23:06:54");
//		setAndPrintTime("23-06-54"); // java.time.format.DateTimeParseException
//		setAndPrintTime("23시06분54"); // java.time.format.DateTimeParseException
		setAndPrintDateTime("2026-08-04T13:20:05");
//		setAndPrintDateTime("2026-08-04 13:20:05"); // java.time.format.DateTimeParseException
		
		// 날짜 포멧 -> 날짜를 표현하는 방법(2026년 6월 24일)
		// 시간 포멧 -> 시간을 표현하는 방법(23시 11분 56초)
		printNowDateWithFormat();
		printNowTimeWithFormat();
		printNowDateTimeWithFormat();
		
		setAndPrintDateWithFormat("2026-08-04","yyyy-MM-dd");
		setAndPrintDateWithFormat("2026년 08월 04일","yyyy년 MM월 dd일");
		
		setAndPrintTimeWithFormat("09시 50분 56초", "HH시 mm분 ss초");
		
		setAndPrintDateTimeWithFormat(
										"2026년 08월 04일 09시 50분 56초",
										"yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		//7년 전
		plusYearAndPrintDateFromNow();
		// 70일 전
		plusDaysAndPrintDateFromNow();
		
		printPeriodFromTo(LocalDate.parse("2000-03-04"), LocalDate.now());
		
		printBetweenDaysFromTo(LocalDate.parse("2000-03-04"), LocalDate.now());
		printBetweenDaysFromTo(LocalDate.now(), LocalDate.parse("2000-03-04"));
		
		
		printIsAfter(LocalDate.parse("2026-08-03"));
		printIsAfter(LocalDate.parse("2026-08-04"));
		printIsAfter(LocalDate.parse("2026-08-05"));
		
		printIsBefore(LocalDate.parse("2026-08-03"));
		printIsBefore(LocalDate.parse("2026-08-04"));
		printIsBefore(LocalDate.parse("2026-08-05"));
		
		printIsToday(LocalDate.parse("2026-08-03"));
		printIsToday(LocalDate.parse("2026-08-04"));
		printIsToday(LocalDate.parse("2026-08-05"));
		
		printChangeYears();
	
	
	
	}

}
