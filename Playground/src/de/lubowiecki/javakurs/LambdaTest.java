package de.lubowiecki.javakurs;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
	
	public static void main(String[] args) {
		
		// Error: Template ist unbekannt
		// (a) -> System.out.println(a);
		
		// Ok: Template ist die abstrakte Methode von NextIA
		NextIA n1 = (a) -> System.out.println(a);
		
		// Ein Lambdaausdruck ist die Vereinfachung eine anonymen Klasse
		
		// anonyme Klasse: Klassendefinition hat keinen Nameun und kann nicht noch mal für die
		// Instanzierung weiterer Objekte benutzt werden
		NextIA n3 = new NextIA() { // Neue Klasse ohne Namen die NextIA implementiert wird instanziert
			@Override
			public void machWas(int x) {
				//....
			}
		};
		
		// Ein Lambda ist die Kurzschreibweise für die Implementierung einer abstrakten Methode
		
		List<Integer> list = Arrays.asList(10,20,30,40,50,60);
		show(list, n1);
		
		System.out.println();
		
		show(list, (butterbrot) -> System.out.print(butterbrot + ","));
		System.out.println();
		
		show(list, (gurkensalat) -> System.out.print(gurkensalat * gurkensalat + ","));
		System.out.println();
		
		NextIA n2 = (i) -> {
			if(i > 20) {
				System.out.print(i + ",");
			}
		};
		
		show(list, n2);
		System.out.println();
		
		// n2.machWas(100); // Verwendung der Definition aus Zeile 29
		
		
		Object o = new String();
		
		// anonyme Klasse
		o = new NextIA() { // DAS IST KEINE INSTANZIERUNG VON NextIA!!!

			@Override
			public void machWas(int a) {
				System.out.println(a);
			}
		};
		
		// Error: Hier ist unbekannt welches Template für das Lambda verwendet wird
		// o = (a) -> System.out.println(a); 
		
		
	}
	
	// n muss eine Implementierung des NextIA sein d.h. die machWas-Methode bereitstellen
	public static void show(List<Integer> l, NextIA n) {
		
		for(int i : l) {
			n.machWas(i); // das Lambda wird mit den Werten der ArrayList aufgerufen
		}
	}
}

@FunctionalInterface
interface NextIA {
	
	// FunctionalInterface enthalten nur EINE abstrakte Methode
	void machWas(int x);
	
}
