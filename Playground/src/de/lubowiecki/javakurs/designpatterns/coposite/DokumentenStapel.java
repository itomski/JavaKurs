package de.lubowiecki.javakurs.designpatterns.coposite;

import java.util.ArrayList;
import java.util.List;

public class DokumentenStapel implements Dokument {

	private List<Dokument> dokumente = new ArrayList<>();
	
	public void hinzufuegen(Dokument dok) {
		dokumente.add(dok);
	}
	
	public void entfernen(Dokument dok) {
		dokumente.remove(dok);
	}

	@Override
	public void print() {
		for(Dokument dok : dokumente) {
			dok.print();
		}
	}
}
