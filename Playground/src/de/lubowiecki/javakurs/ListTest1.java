package de.lubowiecki.javakurs;

import java.util.ArrayList;
import java.util.List;

public class ListTest1 {

	public static void main(String[] args) {
		
		// RawType ist per default Object
		List list = new ArrayList<>();
		
		list.add(1); // Integer IS-A Object
		list.add("Moin"); // String IS-A Object
		list.add(new Object());
		
		//Integer i = list.get(0); // get liefert ein Objekt
		//Integer.max(list.get(0), 1); // Compilerfehler: get liefert ein Object
	}
}
