package de.lubowiecki.javakurs;

import java.time.temporal.ChronoUnit; // normaler Import importiert nur Klassen
//Statische Imports importieren das statische Inventar (z.B. Eigenschaften und Methoden) einer Klasse, nicht die Klasse selbst!!!
import static java.time.temporal.ChronoUnit.*; 

public class StrTest {

	public static void main(String[] args) {
		
		String s1 = "good";
		String s2 = "";
		char[] c = {'g', 'o', 'o', 'd'};
		
		for(char ch : c)  {
			s2 = s2 + ch;
		}
		
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		System.out.println();
		
		Object x = null;
		s2 = null;
		
		System.out.println(x); // toString
		System.out.println(s2 == null); // true
		System.out.println(s2 == x); // s2 und x zeigen auf das gleich null auf dem Speicher

		
		String s = "Moin"; // Landet im String-Pool
		s = new String("Moin"); // Landet NICHT im Pool
		
		Object o = s; // Ok: String IS-A Object
		s = (String) o; // Nicht jedes Objekt ist ein String, daher  Cast
		
		//Integer i = (Integer) s; // Error: String ist kein Integer
		Integer i = (Integer) o; // ClassCastException, o könnte ein Integer sein, weil es Object ist
		// zur Laufzeit wird aber festgestellt, dass ein String ist -> ClassCastException
		System.out.println(i); 
		
		
		System.out.println(ChronoUnit.DAYS); // Ohne statischen Import
		System.out.println(DAYS); // Mit statischen Import
		
		Object t = new Integer(100);
		//int k = (Integer) t.intValue() / 9; // Error: intValue() in Object nicht enthalten
		
		
	}

}
