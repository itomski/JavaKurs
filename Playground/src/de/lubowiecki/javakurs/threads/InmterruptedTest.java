package de.lubowiecki.javakurs.threads;

import java.util.Scanner;

public class InmterruptedTest {

	public static void main(String[] args) {
		
		Runnable r = () -> { // Lambda ist die Implementierung der run-Methode
			
			while(true) {
				if(Thread.currentThread().isInterrupted()) // Prüft, ob der Thread als abgebrochen markiert ist
					break;
				
				System.out.println("Hi");
				
				try {
					Thread.sleep(500);
				} 
				catch (InterruptedException e) {
					System.out.println("T: Interrupted");
					// Wenn der Thread im Schlaf abgebrochen wird, dann wirft er eine Exception
					// wird aber nicht als abgebrochen markiert. 
					Thread.currentThread().interrupt(); // markiert den Thread als abgebrochen
				}
			}
		};
		
		Thread otherThread = new Thread(r); // 
		otherThread.start(); // erst hier startet die Abarbeitung des Runnables
		
		Scanner scanner = new Scanner(System.in);
		
		if(scanner.nextLine().trim().toLowerCase().equals("exit")) {
			otherThread.interrupt();
		}
		
//		try {
//			Thread.sleep(5_000);
//			// Wenn der Thread schläft, wird er nicht als abgebrochen markiert, sondern er wirft er InterruptedException
//			otherThread.interrupt(); 
//		} 
//		catch (InterruptedException e) {
//			System.out.println("main: Interrupted");
//		}
	}

}
