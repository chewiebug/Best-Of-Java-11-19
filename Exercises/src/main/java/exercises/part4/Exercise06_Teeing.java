package exercises.part4;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise06_Teeing 
{
	public static void main(final String[] args) 
	{
		Stream<City> exampleCities = Stream.of(
				new City("Zürich", "Europe"),
				new City("Bremen", "Europe"),
				new City("Kiel", "Europe"),
				new City("San Francisco", "America"),
				new City("Aachen", "Europe"),
				new City("Hong Kong", "Asia"),
				new City("Tokyo", "Asia"));
		
		Predicate<City> isInEurope = city -> city.locatedIn("Europe");
		Predicate<City> isInAsia = city -> city.locatedIn("Asia");
		
		// TODO
		// var result = exampleCities.collect(teeing(
		
		// System.out.println(result);
	}
	
	static class City 
	{
		private final String name;
		private final String region;

		public City(String name, String region) {

			this.name = name;
			this.region = region;
		}

		public String getName() {
			return name;
		}

		public String getRegion() {
			return region;
		}
		
		public boolean locatedIn(String region) {
			return this.region.equalsIgnoreCase(region);
		}
	}
}
