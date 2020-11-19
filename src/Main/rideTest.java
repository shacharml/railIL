package Main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class rideTest {

	@Test
	void test() {

		ArrayList<travel> testRides = new ArrayList<>();

		stopovers s1 = new stopovers("tel aviv", 11, 0);
		ArrayList<stopovers> allS1 = new ArrayList<stopovers>();
		allS1.add(s1);
		travel t1 = new travel("Binyamina", "Modiin", 10, 30, allS1);

		stopovers s2 = new stopovers("tel aviv", 11, 0);
		ArrayList<stopovers> allS2 = new ArrayList<stopovers>();
		allS2.add(s2);
		travel t2 = new travel("Binyamina", "Modiin", 10, 12, allS2);

		stopovers s3 = new stopovers("tel aviv", 11, 30);
		ArrayList<stopovers> allS3 = new ArrayList<stopovers>();
		allS3.add(s3);
		travel t3 = new travel("Binyamina", "Modiin", 10, 56, allS3);

		testRides.add(t1);
		testRides.add(t2);
		testRides.add(t3);
		
		// System.out.println(testRides.toString());

		// the String of the output
		String theRide = serchByRide(testRides, 12, 10, "Binyamina", "Modiin");
		//System.out.println(theRide);
		
		
		// what we want to be the output
		String theTest = "travel [Starting State=Binyamina, Lastg State=Modiin, Departure time = 10:30the stops overes between this stations: [ [name=tel aviv,  11:00]\n"
				+ "]] \n"
				+ "travel [Starting State=Binyamina, Lastg State=Modiin, Departure time = 10:12the stops overes between this stations: [ [name=tel aviv,  11:00]\n"
				+ "]] \n"
				+ "travel [Starting State=Binyamina, Lastg State=Modiin, Departure time = 10:56the stops overes between this stations: [ [name=tel aviv,  11:30]\n"
				+ "]] \n";

		assertEquals(theTest, theRide);
		
	}

	public static String serchByRide(ArrayList<travel> allTravels, int minute, int hour, String startingState1,
			String lastState1) {

		int counter = 0;
		String theRide = "";

		for (int i = 0; i < allTravels.size() && counter <= 3; i++) {
			if (allTravels.get(i).getStartingState().equalsIgnoreCase(startingState1)) {
				if (hour <= allTravels.get(i).getHour() && minute <= allTravels.get(i).getMinute()) {
					if (allTravels.get(i).getLastgState().equalsIgnoreCase(lastState1)) {
						theRide += allTravels.get(i).toString();
						counter++;
						continue;
					}

					for (int k = 0; k < allTravels.get(i).getAllStopovers().size(); k++) {
						if (allTravels.get(i).getAllStopovers().get(k).getName().equalsIgnoreCase(lastState1)) {
							if (hour <= allTravels.get(i).getAllStopovers().get(k).getHour()
									&& minute <= allTravels.get(i).getAllStopovers().get(k).getMinute()) {
								theRide += allTravels.get(i).toString();
								counter++;
								continue;
							}
						}
					}

				}
			}
			for (int k = 0; k < allTravels.get(i).getAllStopovers().size(); k++) {
				if (allTravels.get(i).getAllStopovers().get(k).getName().equalsIgnoreCase(startingState1)) {
					if (hour <= allTravels.get(i).getAllStopovers().get(k).getHour()
							&& minute <= allTravels.get(i).getAllStopovers().get(k).getMinute()) {
						if (allTravels.get(i).getAllStopovers().get(k).getName().equalsIgnoreCase(lastState1)) {
							theRide += allTravels.get(i).toString();
							counter++;
							continue;
						}

					}
				}
			}

			for (int j = 0; j < allTravels.get(i).getAllStopovers().size(); j++) {

				if (allTravels.get(i).getAllStopovers().get(j).getName().equalsIgnoreCase(startingState1)) {

					for (int j2 = j; j2 < allTravels.get(i).getAllStopovers().size(); j2++) {
						if (allTravels.get(i).getAllStopovers().get(j2).getName().equalsIgnoreCase(lastState1)) {
							theRide += allTravels.get(i).toString();
							counter++;
							continue;
						}

					}

				}

			}

		}
		return theRide;
	}
}
