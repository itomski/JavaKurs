package de.lubowiecki.javakurs;

import java.util.Scanner;

public class ScannerTest {
	
	private static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
		while(true) {
			System.out.print("Eingabe: ");
			String eingabe = input.nextLine();
			System.out.println(">>> " + eingabe);
			
			if(eingabe.equalsIgnoreCase("exit")) {
				break;
			}
//			else if(eingabe.equalsIgnoreCase("add")) {
//				//...
//			}
			
			System.out.print("Zahl: ");
			double d = input.nextDouble();
			System.out.println(">>> " + d);
			
			System.out.print("Zahl: ");
			int i = input.nextInt();
			System.out.println(">>> " + i);
			
			input.nextLine(); // fix
		}
		
		System.out.println("Ende");
	}

	void machWas() {
	}
	
	// Methode wurde überladen
	void machWas(String s) {
		
	}
	
	// Methode wurde überladen
	void machWas(int i) {
		// Hallo Welt
	}

}
