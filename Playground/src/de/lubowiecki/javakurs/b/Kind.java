package de.lubowiecki.javakurs.b;

import de.lubowiecki.javakurs.a.Mutter;

public class Kind extends Mutter {
	
	public static void main(String[] args) {
		
		Mutter m = new Mutter();
		//System.out.println(m.zahl); // Error: Hier keine Erbbeziehung
		
		Kind k = new Kind();
		System.out.println(k.zahl); // Ok: Erbbeziehung, Ausführung in der Klasse Kind
		
	}

}
