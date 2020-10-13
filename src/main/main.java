package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import Main.stopovers;
import Main.travel;

public class main {
	
	///rail?outfomate=html&startS=Binyamina&lastS=Modiin&hour=12&minutes=10

	public static void main(String[] args) throws FileNotFoundException {
		
		
		System.out.println("<h1 style=\"text-align:center;font-family:tahoma\">The Rail IL Poject</h1>");
		
		
		System.out.println("<div style=\"border: 2px solid black\"> <p style=text-align:center;font-family:courier;font-size:140%>"
		+ "Your travel for serch :"+"<br>"+
		"Starting state :" + args[1] +"<br>"+
		"Last state : "+ args[2] + "<br>"+
		"Hour- "+ Integer.parseInt(args[3]) +":"+ Integer.parseInt(args[4])+ "</p></div>"+"<br>");
		
		
		String startingS = args[1];
		String LastS = args[2];
		int hour = Integer.parseInt(args[3]);
		int minutes = Integer.parseInt(args[4]);
		
		
		
		File f = new File("/home/anet/git/railIL/allTravels.txt");

		ArrayList<travel> allTravels = scanFromFile(f);
		
		serchByRide(startingS, LastS, hour, minutes, allTravels);
   
		

	}
	
	
	public static void serchByRide(String startingState1 , String lastState1 , int hour , int minute ,ArrayList<travel> allTravels ) {
		
		int counter =1 ;
		
       while (hour > 24 || hour <= 0) {
					System.out.println("<p style=\"color:red;\";font-family:courier;font-size:130%>"
							+ "Enter hour again  it is incorrect </p>");
					
    	   return;
				}
				while (minute > 59 || minute < 0) {
					System.out.println("<p style=\\\"color:red;\\\";font-family:courier;font-size:130%>"
							+ "Enter minute again it is incorrect </p> ");
					
					return;
				}

				//we want 3 rides who start in Binyamina to Modiin in 10:12
				
				for (int i = 0; i < allTravels.size() && counter <= 3; i++) {
					
					if (allTravels.get(i).getStartingState().equalsIgnoreCase(startingState1) && 
						allTravels.get(i).getLastgState().equalsIgnoreCase(lastState1)) {
					
						if (allTravels.get(i).getHour() >= hour && 
								allTravels.get(i).getMinute() >= minute) {
							
							System.out.println("<div style=\"border: 2px solid black\"> "
									+ "<p style=\"color:blue;\";font-family:courier;font-size:120%>"
									+allTravels.get(i).toStringHTML(counter) + "</p></div>" +"<br>");
							counter++;
							continue;
							
							
						}
					}
					
				}		
	} 
	
	public static ArrayList<travel> scanFromFile(File f) throws FileNotFoundException {

		ArrayList<travel> allTravels = new ArrayList<travel>();

		Scanner s = new Scanner(f);

		while (s.hasNext()) {

			int sizeArr = s.nextInt();

			for (int i = 0; i < sizeArr; i++) {
				s.nextLine();
				String startingState = s.nextLine();
				String lastState = s.nextLine();
				int hour = s.nextInt();
				int minute = s.nextInt();
				int howManyStopover = s.nextInt();

				ArrayList<stopovers> allStopover = new ArrayList<stopovers>();

				for (int j = 0; j < howManyStopover; j++) {
					s.nextLine();
					String name = s.nextLine();
					int hour1 = s.nextInt();
					int minute1 = s.nextInt();

					allStopover.add(new stopovers(name, hour1, minute1));

				}

				travel a = new travel(startingState, lastState, hour, minute, allStopover);
				allTravels.add(a);

			}

		}

		return allTravels;
	}

}
