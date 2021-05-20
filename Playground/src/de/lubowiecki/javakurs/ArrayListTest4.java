package de.lubowiecki.javakurs;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest4 {

	public static void main(String[] args) {
		
		List<Integer> al1 = new ArrayList<>();
		al1.add(1);
		al1.add(2);
		al1.add(3);
		
		System.out.println(al1);
		
		List<Integer> al2 = new ArrayList<>(al1);
		System.out.println(al2);
		
		System.out.println();
		
		al1.set(0, 5); // Integer sind immutable, neuer Wert führt zu einer neuen Referenz
		al2.set(1, 7);
		System.out.println(al1);
		System.out.println(al2);
		
		System.out.println("------------------");
		
		List<Zeug> al3 = new ArrayList<>();
		al3.add(new Zeug(1));
		al3.add(new Zeug(2));
		al3.add(new Zeug(3));
		
		System.out.println(al3);
		
		// Arrays.asList() Erzeugt eine FixSizeListe
		
		List<Zeug> al4 = new ArrayList<>(al3); // Collections sind keine Speicher für Werte, sondern Speicher für Referenzen
		System.out.println(al4);
		
		System.out.println();
		
		al3.get(0).setCount(5);
		al4.add(new Zeug(10));
		al3.add(new Zeug(7));
		
		System.out.println(al3);
		System.out.println(al4);
		
		
		//final boolean b = false; // Kompiletime-Konstante
		
		final boolean b;
		
		b = false; // Runtime-Konstante
		
		if(b) {
			System.out.println("Moin");
		}
		
		while(b) {
			System.out.println("Moin");
		}
		
		int i = 10;
		i /*10*/ += i /*10*/  + ++i /*11*/;
		System.out.println(i);
		
		System.out.println(new Boolean(false));
		System.out.println(new Boolean(null));
		System.out.println(new Boolean("TRue"));
		System.out.println(new Boolean("xyz"));
		
		System.out.println(new Boolean("true") == Boolean.TRUE); // false, Referenzvergleich
		System.out.println(new Boolean("true") == true); // true, Objekt wird ausgepackt, Vergleich erfolgt primitiv
		// ist einer der Operanden für den Vergleich primitiv, wird der komplexe Boolean ausgepackt
		// Werden zwei Boolean-Objekte mit == verglichen, erfolgt ein Referenzvergleich
		
		int[] arr = {1,2,3,4,5};
		
		for(final int j : arr) {
			System.out.println(j);
		}
		
		System.out.println();
		
		for(int j : arr) {
			System.out.println(j);
		}
		
		String s = "01234567";
		// System.out.println(s.substring(4, 3));
		
		
		long l = 100; // int > primitive widening zu long
		byte b3 = 12;
		l = b3; // byte > primitive widening zu long
		
		//Long l2 = 100; // int > Autoboxing Integer > Error: komplex widening > Integer zu Long (nicht möglich)
		Integer i2 = 100;
		long l3 = i2; // Integer i2 AutoUnBoxing zu int, primitive widening von int zu long
		
		System.out.println();
		
		BasicZeug bz = new Zeug(10);
		System.out.println(bz.getCount());
		
		int a = 11;
		
		loop: {
			
			System.out.println("A");
			
			if(a >= 10) 
				break loop;
			
			System.out.println("B");
		}
		
		
		float f = 0x000000123;
		System.out.println(f);
		
		System.out.println(43e1);
		
		Integer i5 = 10;
		Double d5 = 10d;
		Object o5 = 10d;
		//System.out.println(i5 == d5);
		System.out.println(i5.equals(d5));
		
		Integer i6 = 10; // int AutoBoxing zu Integer
		// Long l6 = 10; // Error: int AutoBoxing zu Integer
		Object o6 = 10; // int AutoBoxing zu Integer, Komplex Widening von Integer zu Object
		
		int i7 = 10;
		
		// postfix wird nachträglich ausgeführt aber spätestens vor den nächsten verwendung von i7
		System.out.println(i7++ + /* postfix wird vor diesem i angewandt */ i7++); // 11++
		System.out.println(i7); // 12
		
		i7 = 10;
		System.out.println(i7++ /*10*/ + ++i7 /*12*/); // 22
		
		i7 = 10;
		System.out.println(i7/*10*/++  + i7/*11*/++  + i7/*12*/++  + i7/*13*/++); //++ auf i7 nach der Addition 
		System.out.println(i7); /*14*/
		
	}
}

class BasicZeug {
	
	public BasicZeug() {
		getCount(); // Wenn BasicZeug als Teil von Zeug gebaut wird, dann ruft es die getCount() von Zeug auf
		// Wenn BasicZeug eigenständig instanziert wird, ruft es die eigene getCount()-Methode auf
	}
	
	public int getCount() {
		System.out.println(-1);
		return -1;
	}
}

class Zeug extends BasicZeug {
	
	private int count = 11;

	public Zeug(int count) {
		super(); // Ruft den Kostruktor von BasicZeug auf
		this.count = count;
	}

	public int getCount() {
		System.out.println(count);
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Zeug [count=" + count + "]";
	}
}
