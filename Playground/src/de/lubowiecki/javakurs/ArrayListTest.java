package de.lubowiecki.javakurs;

import java.util.ArrayList;

import de.lubowiecki.javakurs.data.Thing;

// Ist von Object abgeleitet 
public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList(); // Standard RawType ist Object 
		list1.add("Steve");
		list1.add(new Object());
		list1.add(new ArrayListTest());
		
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		System.out.println();
		
		for(Object o : list1) {
			System.out.println(o);
		}
		
//		System.out.println();
//		list1.forEach(o -> System.out.println(o));
		
		System.out.println();
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Peter");
		list2.add("Steve");
		list2.add("Natasha");
		list2.add("Bruce");
		list2.add("Tony");
		
		for(String s : list2) {
			System.out.println(s.toUpperCase());
		}
		
		System.out.println();
		ArrayList<Thing> list3 = new ArrayList<>();
		
		Thing t3 = new Thing("Zange");
		
		// add: An Position hinzufügen
		list3.add(t3);
		list3.add(new Thing("Hammer"));
		list3.add(new Thing("Schraubendreher"));
		
		for(Thing t : list3) {
			System.out.println(t.getName());
		}
		
		System.out.println();
		t3.setName("Neue Zange");
		// get: An Position abfragen
		System.out.println(list3.get(0).getName());
		System.out.println(t3.getName());
		
		System.out.println();
		// set: Ersetzen an Position
		list3.set(2, new Thing("Stift"));
		System.out.println(list3);
		
		System.out.println();
		// remove: an Position löschen
		list3.remove(2);
		System.out.println(list3);
	}
	
	// Beschreibt wie das Objekt in String konvertiert wird
	@Override
	public String toString() {
		return getClass().getSimpleName() + " ...";
	}
}
