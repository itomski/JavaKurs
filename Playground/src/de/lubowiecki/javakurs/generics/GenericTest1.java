package de.lubowiecki.javakurs.generics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenericTest1 {

	public static void main(String[] args) {
		
		List list = new ArrayList(); // Raw-Typ ist Object
		list.add(100);
		list.add("Hallo");
		list.add(LocalDate.now());
		
		for(Object o : list) {
			System.out.println(((String)o).toUpperCase());
		}
		
		System.out.println();
		List<String> list2 = new ArrayList<>(); 
		list2.add("Moin");
		
		// Generische Typen werden durch den Kompiler entfernt und durch Casts ersetzt
		list2.add((String) "Moin"); // z.B. Casts auf ein String
		String a = (String) list2.get(1);
		
		for(String s : list2) {
			System.out.println(s.toUpperCase());
		}
	}

}
