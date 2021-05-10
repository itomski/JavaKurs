package de.lubowiecki.javakurs;

public class KontrollstrukturenTest1 {

	public static void main(String[] args) {
		
		String msg = "Nachricht";
		
		if(msg.length() > 0 && msg.length() < 10) {
			System.out.println("#1");
			System.out.println("#1b");
		}
		else if(msg.length() > 5 && msg.length() < 20)
			System.out.println("#2");
			// System.out.println("#2b"); // Kompilerfehler, da nachfolgendes else isoliert ist
		
		else
			System.out.println("#3");
		
		// Kurzschreibweise für if
		int i = (msg.length() > 2) ? 1 /* true */ : 0 /* false */;
		
		
		i = (msg.length() > 2) ? (msg.length() > 5) ? 2 : 1 : 0;
		System.out.println(i);

		if(msg.length() > 2)
			if(msg.length() > 5)
				i = 2;
			else
				i = 1;
		else
			i = 0;
		
		System.out.println("--- switch ---");
		
		//byte b = 10;
		//char b = 10;
		//long b = 10;
		// erlaubte primitive: byte, short, char, int 
		
		//String b = "";
		//Integer b = 1;
		// erlaubte komplexe: String, Byte, Short, Character, Integer,
		
		// Und ENUMs
		Wochentage b = Wochentage.MI;
		
		// Variablen können als Input verwendet werden
		// Aber nicht als Cases
		// Cases müssen einzigartig sein
		switch(b) {
		
			case DI:
			case DO:
			case FR:
					int ix = 10; // Variable wird für das komplette switch deklariert, aber erst im Block initialisiert
					System.out.println("Basketball" + ix);
					// return;
				break;
				
			case MO:
			case SA:
			case SO:
					ix = 20;
					System.out.println("Arbeit" + ix);
				break;
				
			default: // Muss NICHT als letztes definiert werden. Wird ausgeführt, wenn kein Case in Frage kam
				ix = 30;
				System.out.println(ix);
		}
	}

}
enum Wochentage {
	MO, DI, MI, DO, FR, SA, SO;
}

