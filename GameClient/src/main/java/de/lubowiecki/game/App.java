package de.lubowiecki.game;

import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String user = null;
		
		try {
			Client client = new Client("localhost", 5000);
			System.out.println("Client wurde gestartet.");
			
			String input = null;
			
			System.out.println("Wie ist dein Username?");
			user = scanner.nextLine();
			
			app: while(true) {
				System.out.print("#:");
				input = scanner.nextLine();
				
				if(input.equalsIgnoreCase("exit"))
					break app;
				
				client.send(new Message(input, user));
				
			}
			
			System.out.println("Client wurde beendet.");
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
