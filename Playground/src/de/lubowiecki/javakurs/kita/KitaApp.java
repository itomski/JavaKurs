package de.lubowiecki.javakurs.kita;

import java.util.ArrayList;
import java.util.Scanner;

public class KitaApp {
	
	private final Scanner scanner = new Scanner(System.in);
	private final ArrayList<KitaGruppe> gruppen = new ArrayList<>();
	
	// Konstante
	private static final String KEYS = "\n**************************************\n"
									 + "  g: Guppe anlegen\n"
									 + "  gs: Guppen anzeigen\n"
									 + "  k: Kind für eine Gruppe erfassen\n"
									 + "  h: Hilfe\n"
									 + "  q: Programm beenden\n"
									 + "**************************************\n";
	
	
	// snakecase kita_gruppe
	// screaming snakecase KITA_GRUPPE
	// camel case KitaGruppe
	
	public static void main(String[] args) {
		new KitaApp().start();
	}

	private void start() {
		// TODO: Altdaten Einlesen
		System.out.println(KEYS);
		
		boolean exit = false;
		
		while(!exit) {
			System.out.print("Auswahl: ");
			switch(scanner.nextLine().trim().toLowerCase()) {
			
				case "g": System.out.println("Gruppe");
					String gruppenName = CliHelper.readString("Gruppenname: ", scanner);
					KitaGruppe gruppe = new KitaGruppe(gruppenName);
					gruppen.add(gruppe);
					
					// gruppen.add(new KitaGruppe(CliHelper.readString("Gruppenname", scanner)));
					
					System.out.println("Gruppe wurde gespeichert.");
					break;
					
				case "gs": System.out.println("Gruppen");
					for(KitaGruppe g : gruppen) {
						System.out.println(g);
					}
					break;
				
				case "k": System.out.println("Kind");
					// TODO: Kind erfassen und einer KitaGruppe zuordenen
					break;
					
				case "q": System.out.println("Programmende");
					exit = true;
					// TODO: Daten speichern/persistieren
					break;
					
				case "h":
					System.out.println(KEYS);
					break;	
					
				default:
					System.out.println("Falsche Eingabe!");
					System.out.println(KEYS);
			}
		}
		
		// TODO: Kind updaten
		// TODO: KitaGruppe updaten
		// TODO: Kind aus einer KitaGruppe entfernen
	}
}
