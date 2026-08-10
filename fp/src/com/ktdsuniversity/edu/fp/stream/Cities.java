package com.ktdsuniversity.edu.fp.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ktdsuniversity.edu.fp.objects.City;
import com.ktdsuniversity.edu.fp.objects.CityList;

public class Cities {
	
	// 1. 모든 도시의 이름만 출력해본다.
	public static void printAllCountryName(String path, String filename) {

		Stream<City> cityList= CityList.loadCityStream(path,filename);
		cityList.map(City::getName)
				.forEach(System.out::println)
				;
		
	}
	
	// 2. countyName이 "South Korea인 데이터의 Native를 중복없이 출력해본다.
	public static void printSouthKoreaData (String path, String filename) {
		
		Stream<City> cityList= CityList.loadCityStream(path,filename);
		cityList.filter(city -> city.getCountryName().equals("South Korea")) //Stream<City>
				.map(city -> city.getNativeStr()) //Stream<String>
				.distinct() //Stream<String>
				.forEach(System.out::println)
		
		;
		
	}
	// 3. 모든 도시의 population을 출력해본다.
	public static void printAllPopulation (String path, String filename) {
		
		Stream<City> cityList= CityList.loadCityStream(path,filename);
		cityList.map(city -> city.getPopulation()) //Stream<Integer>
				.forEach(System.out::println)
				;
	}
	
	// 4. 모든 도시의 popolation을 출력해본다. 단 0이상만 출력해본다.
	public static void printPopulation (String path, String filename) {
		
		Stream<City> cityList= CityList.loadCityStream(path,filename);
		cityList.filter(city -> city.getPopulation() > 0) //Stream<Integer>
				.map(city -> city.getPopulation())
				.forEach(System.out::println)
				;
	}
	// 5. countryName이 "A"로 시작하는 국가의 도시들의 TimeZone을 중복없이 출력해본다.
	public static void printStartACountryName(String path, String filename) {
		Stream<City> cityList= CityList.loadCityStream(path,filename);
		cityList.
	}

	// 6. countryId가 10 이상인 국가들의 도시명을 출력해본다.
	public static void printCountryIdTenOverName(String path, String filename) {
		Stream<City> cityList= CityList.loadCityStream(path,filename);
		cityList.filter(city -> city.getCountryId() >= 10)
				.map(city -> city.getName())
				.forEach(System.out::println);
		;
	}

	// 7. countryName이 "South Korea"인 도시의 population 총 합을 출력해본다.
	public static void printSouthKoreaSumPopulation(String path, String filename) {
		Stream<City> cityList= CityList.loadCityStream(path,filename);
		int result = cityList.filter(city -> city.getCountryName().equals("South Korea"))
							  .collect(Collectors.summingInt(City::getPopulation))
		;
		System.out.println(result);
	}

	// 8. population 기준으로 내림차순 정렬해 10개 도시의 이름과 population을 출력해본다.

	// 9. type이 "special self-governing province" 인 도시의 이름과 countryName을 출력해본다.

	// 10. 모든 도시들을 id 별로 오름차순 정렬해 출력해본다.

	// 11. iso2 값이 숫자 형태인 것만 출력해본다.

	// 12. iso2 값이 숫자형태가 아닌 도시의 국가명(countryName)을 오름차순 정렬해 출력해본다.

	// 13. 국가명(countryName) 별 도시의 목록을 그룹핑하여 출력해본다.

	// 14. latitude와 longitude가 없는 도시들의 이름만 출력해본다.

	// 15. 국가명(countryName)이 Canada인 도시 중 3개는 건너띄고 2개만 출력해본다.

	// 16. level과 parentId가 0보다 큰 도시만 출력해본다.
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\211-11\\Desktop\\java-stream-countries-states-cities-database-master\\csv";
		String filename = "states.csv";
//		
//		Stream<City> cityList= CityList.loadCityStream(path,filename);
//		cityList.forEach(System.out::println);
//		
//		cityList= CityList.loadCityStream(path,filename);
//		cityList.forEach(System.out::println);
		/* 1번 */
//		printAllCountryName(path, filename);
		/* 2번 */
//		printSouthKoreaData(path, filename);
		/* 3번 */
//		printAllPopulation(path, filename);
		/* 4번 */
//		printPopulation(path, filename);
		
		/* 6번 */
//		printCountryIdTenOverName(path, filename);
		/*7번*/
		printSouthKoreaSumPopulation(path, filename);
		
		

	}

}
