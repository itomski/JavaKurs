package de.lubowiecki.javakurs;

import java.util.Scanner;

public class ScannerTest {
	
	private static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		System.out.print("Eingabe: ");
		String eingabe = input.nextLine();
		
		System.out.println(">>> " + eingabe);
		
		System.out.print("Zahl: ");
		double d = input.nextDouble();
		
		System.out.println(">>> " + d);

	}

}
