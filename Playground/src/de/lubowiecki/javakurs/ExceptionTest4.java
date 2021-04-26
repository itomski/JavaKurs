package de.lubowiecki.javakurs;

import java.time.DateTimeException;
import java.time.LocalDate;

public class ExceptionTest4 {

	public static void main(String[] args) {
		//System.out.println(createDate("25.15.2000"));
		
		try {
			System.out.println(createDateBetter("25.15.2000"));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		
		System.out.println("-------------");
		
		try {
			bestellePizza(2);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
//	public static LocalDate createDate(String str) {
//		
//		// 25.10.2000
//		String[] parts = str.split("\\."); // regexp
//		int tag = Integer.parseInt(parts[0]);
//		int monat = Integer.parseInt(parts[1]);
//		int jahr = Integer.parseInt(parts[2]);
//		
//		return LocalDate.of(jahr, monat, tag);
//	}
	
	public static LocalDate createDate(String str) {
		
		// ArrayIndexOutOfBoundsException
		// NumberFormatException
		// DateTimeException
		
		int tag = 0;
		int monat = 0;
		int jahr = 0;
		LocalDate datum = null;
		
		try {
			String[] parts = str.split("\\."); // regexp
			tag = Integer.parseInt(parts[0]);
			monat = Integer.parseInt(parts[1]);
			jahr = Integer.parseInt(parts[2]);
			datum = LocalDate.of(jahr, monat, tag);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Deine Eingabe hat ein falsches Format");
		}
		catch(NumberFormatException e) {
			System.out.println("Deine Eingabe enthält ungültige Zeichen");
		}
		catch(DateTimeException e) {
			System.out.println("Deine Eingabe ist kein gültiges Datum");
		}
		
		return datum;
	}
	
	public static LocalDate createDateBetter(String str) throws Exception {
		
		int tag = 0;
		int monat = 0;
		int jahr = 0;
		LocalDate datum = null;
		
		try {
			String[] parts = str.split("\\."); // regexp
			tag = Integer.parseInt(parts[0]);
			monat = Integer.parseInt(parts[1]);
			jahr = Integer.parseInt(parts[2]);
			datum = LocalDate.of(jahr, monat, tag);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new Exception("Deine Eingabe hat ein falsches Format", e);
		}
		catch(NumberFormatException e) {
			throw new Exception("Deine Eingabe enthält ungültige Zeichen", e);
		}
		catch(DateTimeException e) {
			throw new Exception("Deine Eingabe ist kein gültiges Datum", e);
		}
		
		return datum;
	}
	
	public static void bestellePizza(int nr) throws Exception {
		
		if(nr <= 0) {
			throw new Exception("Nummer ist zu niedrig!");
		}
		if(nr > 10) {
			throw new Exception("Nummer ist zu hoch!");
		}
		//....
		System.out.println("Bestellung wurde erfolgreich übermittelt.");
	}
	
}
