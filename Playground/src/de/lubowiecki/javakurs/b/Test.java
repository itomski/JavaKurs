package de.lubowiecki.javakurs.b;

public class Test {

	public static void main(String[] args) {
		
		Kind k = new Kind();
		// System.out.println(k.zahl); // Error 
		// Kind hat eine Erbbeziehung und darf intern zahl nutzen
		// Klasse Test hat kein Erbbeziehung und darf daher zahl nicht sehen

	}

}
