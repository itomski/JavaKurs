package de.lubowiecki.javakurs;

import java.text.NumberFormat;
import java.text.ParseException;

public class ExceptionTest7 {

	public static void main(String[] args) {
		System.out.println("start main");
		
		try {
			System.out.println(m1());
		}
		catch(Exception e) {
			System.out.println("Exception gefangen: " + e.getMessage());
		}
		
//		NumberFormat form = NumberFormat.getCurrencyInstance();
//		System.out.println(form.format(10.00));
//		try {
//			form.parse("10.000,00 €");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		//System.out.println("Hallo" + 1 * 2);
		
		Object o = "Hallo";
		// o = 1;
		Integer i = (Integer) o;
	}
	
	public static int m1() {
		System.out.println("start m1");
		return m2(); // Exception wurde hier nicht behandelt, sie wird an main weitergereicht
	}
	
	public static int m2() {
		System.out.println("start m2");
		return m3(); // Exception wurde hier nicht behandelt, sie wird an m1 weitergereicht
	}
	
	// Eine Methode muss entweder einen Rückgabewert liefern oder eine Exception produzieren
	// void ist auch ein Rückgabewert
	public static int m3() {
		System.out.println("start m3");
		int i = 0;
		return 10 / i;
		// entsteht in einem Methode eine unbehandelte Exception, gibt die Methode keinen Rückgabewert
		//throw new RuntimeException("m3"); // Exception wurde hier nicht behandelt, sie wird an m2 weitergereicht
	}
}
