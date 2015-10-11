/**
package classWork;

import java.util.Scanner;

public class CityPopulationsIncomplete {

	public static void main(String[] args) {
		// Using nextInt() interspersed with nextLine()
		// nextInt() and nextDouble() methods consume (i.e. overlook) leading
		// whitespace but not trailing whitespace
		// nextLine() does not consume leading whitespace but consumes trailing
		// whitespace.

		String lastRead = " ";

		Scanner mainKeyboard = new Scanner(System.in);
		final int EXIT = 10;
		int choice;

		String[] cityNames = { "Albany", "Buffalo", "Niagara Falls", "New York", "Rochester", "Yonkers",
				"Woodbridge,NJ" };

		Integer[][] populations = { { 134995, 129726, 115781, 101727, 101082, 95658, 97856 },
				{ 580132, 532759, 462768, 357870, 328123, 292648, 261310 },
				{ 90872, 102394, 85615, 71384, 61840, 55593, 50193 },
				{ 7891957, 7781984, 7894862, 7071639, 7322564, 8008278, 8175133 },
				{ 332488, 318611, 296233, 241741, 231636, 219773, 210565 },
				{ 152798, 190634, 204297, 195351, 188082, 196086, 195976 },
				{ 35758, 78846, 98944, 90074, 93086, 97203, 99585 }

		};

		Integer[] years = { 1950, 1960, 1970, 1980, 1990, 2000, 2010 };

		do {
			choice = menu(); // display the menu() and store the user's choice
			// process the user's choice
			try {
				switch (choice) {
				case 1: // view all cities, all population statistics
					ViewAll(cityNames, populations, years);
					break;
				case 2: // view specific city, population statistics
					System.out.println("Which city do you wish to study?");
					if (lastRead.equals("nextInt")) {
						mainKeyboard.nextLine(); // consume whitespace
					}
					String cityName = mainKeyboard.nextLine();
					lastRead = "nextLine";
					Integer[] pops = GetCityStatistics(cityName, cityNames, populations, years);
					// display the results
					for (int i = 0; i < pops.length; i++) {
						System.out.println(years[i] + "  " + pops[i]);
					}
					break;
				case 3: // view city populations of a specific year
					System.out.println("which year would you like to view?");

					int year = mainKeyboard.nextInt();
					lastRead = "nextInt";
					pops = GetYearStatistics(year, populations, years);
					//display the results
					for (int i = 0; i < pops.length; i++) {
						System.out.println(cityNames[i] + "  " + pops[i]);
					}
					break;
				case 4:// for all cities, view year with smallest population
					ViewCitiesLowYearPop(cityNames, populations, years);
					break;
				case 5:
				ViewYearsCityLowPop(cityNames, populations, years);
					break;
				case 6: // for specific year, city with lowest population
					System.out.println("Which year's population records  should be searched?");

					year = mainKeyboard.nextInt();
					lastRead = "nextInt";
			cityName = GetSmallestCityforYear(year, cityNames, populations, years);
					System.out.println("City with Lowest Population for Year: " + year + " is : " + cityName);
					break;
				case 7: // view specific year, specific city , the population of
						// that city, that year
					System.out.println("Which city are you studying?");
					if (lastRead.equals("nextInt")) {
						// swallow the whitespace it left behind
						mainKeyboard.nextLine();
					}
					String city = mainKeyboard.nextLine();
					lastRead = "nextLine"; // not really necessary it this case,
											// will shortly be reset
					System.out.println("which year are you focusing on?");

					year = mainKeyboard.nextInt();
					lastRead = "nextInt";
					int pop = GetPopForCityForYear(year, city, cityNames, populations, years);
					System.out.println("Year " + year + " Population of " + city + " recorded:" + pop);
					break;
				case EXIT:
					System.out.println("have a nice day!");

				} // end switch
			} // end try

			catch (NotFoundException ex) {
				// data user has requested can't be found
				System.out.println("request can't be processed, data not available");

			}

		} while (choice != EXIT);

	}

	public static int menu() {
		Scanner keyboard = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n1.View All Cities , Population Statistics"
					+ "\n2.View Specific City, Population Statistics" + "\n3.View Specific Year , City Populations"
					+ "\n4.View All Cities, Year with Lowest Population"
					+ "\n5.View All Years, City with Lowest Population"
					+ "\n6.View Specific Year, City with Lowest Popuation"
					+ "\n7.View Specific City, Specific Year - City Population" + "\n10. Exit the Application");
			choice = keyboard.nextInt();
		} while (choice < 1 || (choice > 7 && choice != 10)); // notice last two
																// expressions
																// are enclosed
																// in separate
																// ()
		return choice; // this is what the user has indicated he wishes the
						// application to accomplish
	}

	/**
	 * 
	 * @param cityNames
	 * @param populations
	 * @param years
	 *            In tabular format: For each year, display the population that
	 *            has been recorded for that year for each city
	 */

/**
	public static void ViewAll(String[] cityNames, Integer[][] populations, Integer[] years) {
		// display heading - each year for which data has been recorded

		for (int i = 0; i < years.length; i++) {
			System.out.print("\t\t\t" + years[i]); // keep all data on the same
													// line - using print
													// instead of println
		}

		System.out.println(); // display blank line

		for (int i = 0; i < populations.length; i++) { // iterate from row to
														// row
			System.out.print("\n" + cityNames[i]); // display the next city name
			if (cityNames[i].length() > 7) {
				System.out.print("\t\t"); // tab over twice
			} else {
				System.out.print("\t\t\t"); // tab over three times
			}
			for (int j = 0; j < populations[i].length; j++) { // iterate through
																// each column
																// within a row

				System.out.print(populations[i][j] + "\t\t\t");

			}
		}

	}

	/**
	 * 
	 * @param cityNames
	 * @param populations
	 * @param years
	 *            For each city determine and display the year its population
	 *            was the least
	 */
	/**
	public static void ViewCitiesLowYearPop(String[] cityNames, Integer[][] populations, Integer[] years) {

	}

	/**
	 * 
	 * @param cityNames
	 * @param populations
	 * @param years
	 *            For each year, determine and display the lowest population
	 *            recorded and which city recorded this population
	 */
	/**
	public static void ViewYearsCityLowPop(String[] cityNames, Integer[][] populations, Integer[] years) {
int compare;
for(int year=0; year< years.length; year++){
	for (int i = 0; i<cityNames.length ; i++){
		if(populations[i][year]< populations[][year]){
		
			}
	}
}

	/**
	 * 
	 * @param cityName
	 * @param cityNames
	 * @param populations
	 * @param years
	 * @return the population statistics of a particular city
	 * @throws NotFoundException
	 * 
	 */
/**
	public static Integer[] GetCityStatistics(String cityName, String[] cityNames, Integer[][] populations,
			Integer[] years) throws NotFoundException {
		int row = -1; // row not found

		// find the position of requested city in cityNames[]

		for (int i = 0; i < cityNames.length; i++) {
			if (cityName.equalsIgnoreCase(cityNames[i])) {
				row = i; // find city we are looking for
				break; // leave loop, no need to look further
			}
		}

		if (row < 0) {
			// can't find the city we were asked to process
			throw new NotFoundException();
		}

		// retrieve all populations on corresponding row from populations[][]
		Integer[] pops = new Integer[populations[row].length];

		for (int col = 0; col < populations[row].length; col++) {
			pops[col] = populations[row][col];
		}

		// return data '
		return pops;

	}

	/**
	 * 
	 * @param year
	 * @param populations
	 * @param years
	 * @return population of all cities recorded for a specific year
	 * @throws NotFoundException
	 */
/**
	public static Integer[] GetYearStatistics(int year, Integer[][] populations, Integer[] years)
			throws NotFoundException {

	}

	/**
	 * 
	 * @param year
	 * @param cityNames
	 * @param populations
	 * @param years
	 * @return name of the city that recorded the smallest population for a
	 *         given year
	 * @throws NotFoundException
	 */
/**
	public static String GetSmallestCityforYear(int year, String[] cityNames, Integer[][] populations, Integer[] years)
			throws NotFoundException {

	} 
	*/

	/**
	 * 
	 * @param year
	 * @param city
	 * @param cityNames
	 * @param populations
	 * @param years
	 * @return the population for a given city for a given year
	 * @throws NotFoundException
	 */
/**	public static int GetPopForCityForYear(int year, String city, String[] cityNames, Integer[][] populations,
			Integer[] years) throws NotFoundException {
		// search the subscript for the given city.
		Integer citySubscript = null;
		Integer yearSubscript = null;
		for (int i = 0; i < cityNames.length; i++) {
			if (city.equalsIgnoreCase(cityNames[i])) {
				citySubscript = i;
				break;
			}
		}
		// search the subscript for the given year
		for (int i = 0; i < years.length; i++) {
			if (year == years[i]) {
				yearSubscript = i;
				break;
			}
		}
		if (citySubscript < 0 || yearSubscript < 0) {
			throw new NotFoundException();
		}
		return populations[citySubscript][yearSubscript];
	}

} // end class

*/