package de.lubowiecki.javakurs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListTest3 {

	public static void main(String[] args) {
		
		// Typ für den Inhalt: <Integer>
		// <...> Generics dürfen nur komplexe Typen sein
		//Collection<Integer> c1 = new ArrayList<>();
		List<Integer> c1 = new ArrayList<>(); // Es gibt folgende Typen: List, Set, Queue, Map
		c1 = new ArrayList<>(100); // Erzeugt ein internes Array mit Größe von 100
		// Vergrößerung: alte size * 3 / 2
		
		// Array hat intern ein Array mit Standard-Größe von 10
		// Map ist nicht vom Collection-Interface abgeleitet
		
		// RawTyp (Object) wird als Inhalts-Type genutzt
		Collection c2 = new ArrayList();
		
		c1.add(10); // Fügt neues Element ans Ende hinzu
		//c1.add(2, 15); // Exception zur Laufzeit, weil index 1 nicht belegt ist
		c1.add(1, 15); // Entweder muss vorhandenen oder der nächsthöhere sein
		
		//c1.get(5); // Exception zur Laufzeit, ArrayIndexOutOfBundsException
		c1.add(null);
		
		ArrayList<Integer> al = new ArrayList<>();
		al.addAll(c1); // Fügt alle Elemente aus c1 hinzu
		// al = new ArrayList<>(c1); // Fügt sofort alle Elemente aus c1 hinzu
		System.out.println(al);
		
		System.out.println();
		
		ArrayList<NextThing> list = new ArrayList<>();
		list.add(new NextThing("Hammer", 2.0));
		list.add(new NextThing("Zange", 0.5));
		
		ArrayList<NextThing> listCopy = (ArrayList<NextThing>) list.clone(); // Clone liefert
		Object copy = list.clone(); // clone liefert immer Object zurück, das Objekt auf dem Heap ist aber eine ArrayList<NextThing>
		
		list.get(0).setName("Vorschlaghammer");
		list.get(0).setGewicht(10.0);
		
		System.out.println(listCopy);
		
		System.out.println();
		
		NextThing nt1 = new NextThing("Hammer", 2.0);
		NextThing nt2 = new NextThing("Hammer", 2.0);
		System.out.println(nt1);
		System.out.println(nt2);
		
		System.out.println(nt1.equals(nt2)); // Wenn zwei Objekte per equals gleich sind, sollen sie den gleichen HashCode haben
		System.out.println(nt1.hashCode());
		System.out.println(nt2.hashCode());
		
		NextThing nt1Clone = (NextThing) nt1.clone();
		System.out.println(nt1Clone);
		
	}
}

// Cloneable als clonbar markieren
class NextThing implements Cloneable {
	
	private String name;
	private double gewicht;

	public NextThing(String name, double gewicht) {
		this.name = name;
		this.gewicht = gewicht;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGewicht() {
		return gewicht;
	}
	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}
	
	// Muss überschrieben werden, da sie sonst nicht public ist
	@Override
	public Object clone() {
		try {
			return super.clone();
		} 
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return "NextThing [name=" + name + ", gewicht=" + gewicht + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(obj instanceof NextThing) {
			NextThing nt = (NextThing) obj;
			return this.name.equals(nt.getName());
		}
		
		return false;
	}
}
