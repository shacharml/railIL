package main;

import Main.travel;

public class main {


	public static void main(String[] args) {
		
		travel tr = new travel(args[1], args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]), null);
		
		System.out.println(tr.toString());
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] +"<br>");
		}

	}

}
