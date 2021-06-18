package de.lubowiecki.javakurs.localization;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class Sample1 {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		lang: while(true) {
			
			System.out.print("Select your language (1: EN, 2: DE, 3: FR):");
			
			switch(scanner.nextInt()) {
			
				case 1: Locale.setDefault(Locale.ENGLISH);
					break lang;
					
				case 2: Locale.setDefault(Locale.GERMAN);
					break lang;
				
				case 3: Locale.setDefault(Locale.FRANCE);
					break lang;
				
				default:
					System.out.println("Wrong selection");
			}
		}
	
		scanner.nextLine(); // fix
		System.out.println();
		
		// getBundle nutzt, wenn nicht anders angegeben, automatisch die Default-Sprache
		// Bundel-Name wird inkl. paket und baseName angegeben
		// Default-Bundle (hier: ui.properties) hat keine Spracherweiterung und Landeserweiterung im Namen
		ResourceBundle bundle = ResourceBundle.getBundle("de.lubowiecki.javakurs.localization.ui");
		
		System.out.println(bundle.getString("welcome"));
		System.out.println(bundle.getString("question"));
		String name = scanner.nextLine();
		System.out.println(bundle.getString("thanks"));
		
		NumberFormat deForm = NumberFormat.getNumberInstance(); // Verwendet automatisch das Default-Locale
		System.out.println(deForm.format(1235.99));
		
		System.out.println(bundle.getString("answer") + " " + name);
		
		System.out.println(bundle.getString("end"));
	}

}
