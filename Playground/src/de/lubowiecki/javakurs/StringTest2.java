package de.lubowiecki.javakurs;

public class StringTest2 {

	public static void main(String[] args) {
		
		String s1 = " Hallo Welt  ";
		System.out.println(s1.length());
		s1 = s1.trim(); // Schneiden die Leerzeichen am Anfang und Ende der Zeichenkette
		System.out.printf("#%s#", s1);
		
		System.out.println();
		
		// StringBuilder hat keine trim-Methode
		StringBuilder sb = new StringBuilder(" Hallo Welt  "); // 16 + 13
		System.out.println(sb.capacity()); // Größe des inneren Arrays
		System.out.println(sb.length()); // Anzahl der Zeichen
		sb.trimToSize(); // Ändert die capacity auf length
		System.out.println("-- trimToSize --");
		System.out.println(sb.capacity());
		System.out.println(sb.length());
		
		System.out.println();
		
		System.out.println(sb.toString().trim());
		
		// length als Eigenschaft ist nur im Array vorhanden 
	}

}
