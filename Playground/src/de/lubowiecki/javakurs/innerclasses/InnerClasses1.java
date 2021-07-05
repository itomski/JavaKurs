package de.lubowiecki.javakurs.innerclasses;

import java.util.AbstractList;
import java.util.List;

public class InnerClasses1 {

	public static void main(String[] args) {
		
		InnerClasses1.Sub1 sub1 = new InnerClasses1.Sub1();
		
		InnerClasses1.Sub2 sub2_1 = new InnerClasses1().new Sub2();
		
		InnerClasses1 outer = new InnerClasses1();
		InnerClasses1.Sub2 sub2_2 = outer.new Sub2();
		
		// Lokale Klasse
		class Sub3 {
		}
		
		// Klasse kann nur innerhalb dieser Methode verwendet werden
		Sub3 sub3 = new Sub3();
		
		
		// anonyme Klasse
		Runnable r1 = new Runnable() { // Instanzierung einer Klasse ohne Namen, die von Runnable erbt

			@Override
			public void run() {
				
			}
		};
		
		// anonyme Klasse - kann auf einem Interface, Enum, abstrakter Klassae oder regulärer Klasse basieren
		// Die Klassendefinition kann nicht noch mal für eine zweite Instanz verwendet werden
		List<Integer> l2 = new AbstractList<Integer>() {

			@Override
			public Integer get(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}
	
	// Statische Innere Klasse
	// Innere Klasse aber nicht abgeleitet von InnerClasses1
	static class Sub1 {
	}
	
	// Instaz-Innere Klasse
	class Sub2 {
		
	}
}
