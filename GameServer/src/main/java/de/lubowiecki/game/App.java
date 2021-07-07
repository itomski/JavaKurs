package de.lubowiecki.game;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Server server = new Server(5000);
			System.out.println("Server wurde gestartet.");
			
			String input = null;
			
			app: while(true) {
				input = scanner.nextLine();
				if(input.equalsIgnoreCase("exit"))
					break app;
			}
			
			System.out.println("Server wurde beendet.");
			
		} 
		catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
		
		
	}
}
