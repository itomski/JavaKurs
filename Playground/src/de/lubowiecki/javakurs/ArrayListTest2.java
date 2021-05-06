package de.lubowiecki.javakurs;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest2 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		System.out.println(list.remove(0)); // Entfernt an Pos und liefert das Objekt zurück
		System.out.println(list.remove(new Integer(2))); // false, da kein Integer in der Liste
		System.out.println(list.remove("b")); // Entfernt das Objekt und liefert true/false zurück
		
		System.out.println();
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(4);
		list2.add(5);
		
		list2.remove(0); // Entfernt an Pos und liefert das Objekt zurück, 0 ist int
		list2.remove(new Integer(5)); // Entfernt das Objekt mit dem Wert 5 und liefert true/false zurück, 5 ist Integer
		
	}

}
