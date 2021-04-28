package de.lubowiecki.javakurs.uebungen.u2;

import java.util.ArrayList;
import java.util.List;

public class Gehege {
	
	private List<Sozialisiert> herde = new ArrayList<>();
	
	void aufnehmen(Sozialisiert s) {
		herde.add(s);
	}
	
	public void starteFuetterung() {
		herde.forEach(s -> s.doFresszeit());
	}
	
	public void starteNachruhe() {
		 herde.forEach(s -> s.doNachtruhe());
	}

}
