package de.lubowiecki.javakurs.kita;

import java.time.LocalDate;

public class KitaTest {

	public static void main(String[] args) {
		
		Kind k1 = new Kind("Peter", "Parker", LocalDate.of(1992, 12, 10));
		Kind k2 = new Kind("Steve", "Rogers", LocalDate.of(1927, 10, 1));
		
		KitaGruppe g1 = new KitaGruppe("Giftzwerge", 5);
		
		g1.addKind(k1);
		g1.addKind(k2);
		
		for(int i = 0; i < g1.getKinder().size(); i++) {
			Kind k = g1.getKinder().get(i);
			System.out.println(k.getVorname() + " " + k.getNachname() + " (" + k.getGeburtsdatum() + ")");
		}
		
		for(Kind k : g1.getKinder()) {
			System.out.println(k.getVorname() + " " + k.getNachname() + " (" + k.getGeburtsdatum() + ")");
		}
	}
}
