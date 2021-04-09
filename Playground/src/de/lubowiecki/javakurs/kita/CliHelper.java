package de.lubowiecki.javakurs.kita;

import java.time.LocalDate;
import java.util.Scanner;

public class CliHelper {

	private CliHelper() {
	}
	
	public static String readString(String label, Scanner scanner) {
		System.out.print(label);
		return scanner.nextLine().trim();
	}
	
	public static int readInt(String label, Scanner scanner) {
		System.out.print(label);
		int number = scanner.nextInt();
		scanner.nextLine();
		return number;
	}
	
	public static LocalDate readLocalDate(String label, Scanner scanner) {
		System.out.print(label);
		// TODO: Formatfehler abfangen
		return LocalDate.parse(scanner.nextLine());
	}
}
