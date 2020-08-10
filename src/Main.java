
// trying for the git
	import java.util.ArrayList;
	import java.util.Scanner;

	public class Main {

		public static void main(String[] args) {

			ArrayList <travel> allTravels = new ArrayList<travel>();
			int choose = 0 , i=0;
			boolean fCountinue = true;
			Scanner s = new Scanner(System.in);
			
			String startingState, lastState;
			int hour, minute;

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
	            
				
				while (hour >24 ||hour <=0 ) {
					System.out.println("Enter hour again : ");
					hour = s.nextInt();
				}
				while (minute > 59 ||minute < 0 ) {
					System.out.println("Enter minute again : ");
					minute = s.nextInt();
				}
				
				travel travel = new travel(startingState, lastState, hour, minute);
				allTravels.add(travel);
				
				System.out.println(allTravels.toString());
				
				
				break;
			}
			case 2: {

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



