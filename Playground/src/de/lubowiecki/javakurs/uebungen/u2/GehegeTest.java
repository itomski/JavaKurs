package de.lubowiecki.javakurs.uebungen.u2;

public class GehegeTest {

	public static void main(String[] args) {
		
		Gehege g = new Gehege();
		g.aufnehmen(new Wolf("Bruno"));
		g.aufnehmen(new Wolf("Milka"));
		g.aufnehmen(new Wolf("Hansen"));
		g.aufnehmen(new Kuh("Berta"));
		g.aufnehmen(new Kuh("Isa"));
		
		g.starteFuetterung();
		
		System.out.println();
		
		g.starteNachruhe();
		

	}

}
