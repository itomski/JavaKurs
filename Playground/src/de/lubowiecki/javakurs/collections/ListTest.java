package de.lubowiecki.javakurs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
	
	private List<String> list;
	
	public static void main(String[] args) {
		
		// List
		// + Arabeitet mit einem Index d.h. zusätzliche indexbasierte Methoden
		// + ist geordnet d.h. behält die Einfügereihenfolge bei
		// + ist sortierbar
		
		
		// tight coupling
		ArrayList<String> list1 = new ArrayList<>();
		
		// loose coupling
		List<String> list2 = new ArrayList<>();
		// ArrayList
		// - hinzufügen/löschen von Elementen mitten drin ist sehr aufwändig (belastet den Speicher)
		// + Wahlfreier Zugriff ist sehr schnell
		
		
		list2 = new LinkedList<>();
		// LinkedList
		// + hinzufügen/löschen von Elementen mitten drin ist sehr schnell
		// - Wahlfreier Zugriff ist langsam
		
		list1.add("Peter");
		list1.add("Carol");
		list1.add("Bruce");
		list1.add("Natasha");
		list1.add("Steve");
		list1.add("Tony");
		
		
		list2 = new LinkedList<>(list1); // Elemente der ArrayList werden in eine LinkedList übertragen
		list2 = new ArrayList<>(list2); // Elemente der LinkedList werden in eine ArrayList übertragen
		
		
		ListTest lt1 = new ListTest(new ArrayList<>());
		ListTest lt2 = new ListTest(new LinkedList<>());
		
		// sort gibt es nur für Listen
		Collections.sort(list2);
		
		System.out.println(list2);
		
		
	}
	
	public ListTest(List<String> list) {
		this.list = list;
	}
}
