import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ArrayList<travel> allTravels = new ArrayList<travel>();
		int choose = 0, i = 0;
		boolean fCountinue = true;
		Scanner s = new Scanner(System.in);

		String startingState, lastState, stopovers;
		int hour, minute, h1,m1;

		do {

			System.out.println(" 1- Enter your travel deatails ");
			System.out.println(" 2- Sort by departure time ");
			System.out.println(" 9- Exit ");

			choose = s.nextInt();
			s.nextLine();

			switch (choose) {
			case 1: {
				System.out.println("Enter your starting state : ");
				startingState = s.nextLine();

				System.out.println("Enter your last state : ");
				lastState = s.nextLine();

				System.out.println("Enter hour : ");
				hour = s.nextInt();

				System.out.println("Enter minute : ");
				minute = s.nextInt();

				while (hour > 24 || hour <= 0) {
					System.out.println("Enter hour again : ");
					hour = s.nextInt();
				}
				while (minute > 59 || minute < 0) {
					System.out.println("Enter minute again : ");
					minute = s.nextInt();
				}
				
				boolean b = true;
				ArrayList<stopovers> allstStopovers = new ArrayList<stopovers>();
				while(b) {
				System.out.println("Enter  your stopovers :");
				stopovers = s.nextLine();
				System.out.println("Enter hour : ");
				h1 = s.nextInt();

				System.out.println("Enter minute : ");
				m1 = s.nextInt();

				while (h1 > 24 || h1 <= 0) {
					System.out.println("Enter hour again : ");
					h1 = s.nextInt();
				}
				while (m1 > 59 || m1 < 0) {
					System.out.println("Enter minute again : ");
					m1 = s.nextInt();
				}
				allstStopovers.add(new stopovers(stopovers, h1, m1));
				System.out.println("you want another stop over? T/F ");
				if(s.nextLine().equals("F")) {
					b=false;
				}
				}

				travel travel = new travel(startingState, lastState, hour, minute,allstStopovers);
				allTravels.add(travel);

				// System.out.println(allTravels.toString());

				break;
			}
			case 2: {
				// sort by hour

				for (int z = 0; z < allTravels.size() - 1; z++) {

					for (int j = 0; j < allTravels.size() - 1; j++) {

						if (allTravels.get(j).getHour() > allTravels.get(j + 1).getHour()) {

							travel temp = allTravels.get(j);
							allTravels.set(j, allTravels.get(j + 1));
							allTravels.set(j + 1, temp);
						}

						if (allTravels.get(j).getHour() == allTravels.get(j + 1).getHour()) {
							if (allTravels.get(j).getMinute() > allTravels.get(j + 1).getMinute()) {
								travel temp = allTravels.get(j);
								allTravels.set(j, allTravels.get(j + 1));
								allTravels.set(j + 1, temp);
							}
						}

					}

				}

				System.out.println(allTravels.toString());

				break;
			}
			case 3: {
				
				break;
			}
			case 9: {
				fCountinue = false;
				break;
			}
			}

		} while (fCountinue);

		s.close();
	}

}