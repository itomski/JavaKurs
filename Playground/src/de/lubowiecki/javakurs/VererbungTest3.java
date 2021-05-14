package de.lubowiecki.javakurs;

public class VererbungTest3 {

	public static void main(String[] args) {
		
		BB bb = new BB();
		bb.machWas1();
		bb.machWas2();
		bb.machWas3();
		
		System.out.println();
		
		AA aa = new BB(); // Erlaubt: BB IS-A AA (IS-A: BB ist direkt oder indirekt von AA abgeleitet)
		// Es sind nur Methoden sichtbar, die AA definiert
		// Methoden-Aufrufe finden aber trotzdem auf dem Objekttyp statt d.h. BB
		aa.machWas1();
		aa.machWas2();
		//aa.machWas3(); // Error: Über AA-Referenz nicht sichtbar
		

	}
}

class AA {
	
	public void AA() { // Das ist KEIN Konstruktor!
		// TODO Auto-generated constructor stub
	}
	
	public void machWas1() {
		System.out.println("AA machWas1");
	}
	
	public void machWas2() {
		System.out.println("AA machWas2");
	}
}

class BB extends AA {
	
	@Override
	public void machWas1() {
		System.out.println("BB machWas1");
	}
	
	public void machWas3() {
		System.out.println("BB machWas3");
	}
	
}
